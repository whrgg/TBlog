package com.traveller.utils;

import com.traveller.entity.Tomail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;
import java.util.Map;
import java.util.Properties;

/**
 * @author traveller
 * @date 2024/04/28
 * 用来发送邮件
 */
@Slf4j
@Component
public class MailUtils {

    @Autowired
    JavaMailSender mailSender;
    @Value("${spring.mail.username}")
    private String from;
    @Value("${blog.name}")
    private String nickname;
    @Autowired
    TemplateEngine templateEngine;

    @Async
    public void sendregisterMessage(Tomail tomail,Integer code) {
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            Context context = new Context();
            context.setVariable("code",String.valueOf(code));

            //注意设置处理器，默认就是classpath:/路径下
            ClassLoaderTemplateResolver resolver = new ClassLoaderTemplateResolver();
            resolver.setSuffix(".html"); // 设置模板文件的后缀
            resolver.setTemplateMode("HTML"); // 设置模板文件的类型
            templateEngine.setTemplateResolver(resolver);
            String process = templateEngine.process("test", context);

            //设置发件人
            messageHelper.setFrom((nickname+'<'+from+'>').toString());
            System.out.println(nickname+'<'+from+'>');
            messageHelper.setTo(tomail.getTos());
            messageHelper.setSubject(tomail.getSubject());
            messageHelper.setText(process, true);
            mailSender.send(mimeMessage);
        } catch (Exception e) {
            log.error("发送邮件失败");
            e.printStackTrace();
        }
    }

}
