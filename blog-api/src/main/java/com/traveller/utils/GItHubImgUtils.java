package com.traveller.utils;

import cn.hutool.Hutool;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.UUID;

/**
 * github图床工具类
 *
 * @author traveller
 * @date 2024/05/06
 */
@Slf4j
public class GItHubImgUtils {
    @Value("github.token")
    static String githubToken;

    /**
     * 上传文件
     *
     * @param filepath
     * @param filePostfix
     * @param message
     * @return {@link String}
     */
    public static String uploading(String filepath, String filePostfix, String message) {
        String fileBase64 = encryptToBase64(filepath);
        String fileName = UUID.randomUUID().toString().replace("-", "") + filePostfix;
        JSONObject param = new JSONObject();
        param.put("message", message);// 提交描述
        param.put("content", fileBase64);// Base64过的文件
        param.put("branch", "main");// 上传到仓库的分支，以前是master;2020.10.01开始就变成了main了
        JSONObject committer = new JSONObject();
        committer.put("name", "traveller"); // 提交的作者或提交者的姓名
        committer.put("email", "2186840198@qq.com");// 提交的作者或提交者的电子邮件
        param.put("committer", committer);
        param.put("sha", "");// 添加的时候没有参数也要写""
        String url = "https://api.github.com/repos/OWNER/REPO/contents/PATH";
        url = url.replace("OWNER", "whrgg")// 存储库的帐户所有者。名称不区分大小写
                .replace("REPO", "IMG")// 仓库名称
                .replace("PATH", "Pho/");// 存储仓库里面的路径
        url = url + fileName;

        HttpResponse response = HttpRequest.put(url)
                .header("Accept", "application/vnd.github+json")
                .header("Authorization", "token "+githubToken).body(param.toString()).execute();
        log.info("响应结果：{}", response.body());
        JSONObject jsonObject = JSONObject.parseObject(response.body());
        // 取出访问地址
        JSONObject content = jsonObject.getJSONObject("content");
        String download_url = content.getString("download_url");
        return download_url;
    }


    public static String encryptToBase64(String filePath) {
        if (filePath == null) {
            return null;
        }
        try {
            byte[] b = Files.readAllBytes(Paths.get(filePath));
            return Base64.getEncoder().encodeToString(b);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
