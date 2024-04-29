package com.traveller.blogcms;

import com.alibaba.druid.support.json.JSONUtils;
import com.traveller.entity.Tomail;
import com.traveller.entity.User;
import com.traveller.mapper.UserMapper;
import com.traveller.properties.JwtProperties;
import com.traveller.service.UserService;
import com.traveller.utils.MailUtils;
import com.traveller.utils.MarkdownUtils;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootTest
class BlogCmsApplicationTests {
    @Autowired
    MailUtils mailUtils;

    @Autowired
    JavaMailSender mailSender;
    /**
     * 发送人
     */
    @Value("${spring.mail.username}")
    private String from;
    @Test
    void contextLoads() {
        String s = MarkdownUtils.ParseMarkdown("~~~java\n" +
                "public static String ParseMarkdown(String markdown) {\n" +
                "        Parser parser = Parser.builder().build();\n" +
                "        Node document = parser.parse(markdown);\n" +
                "        HtmlRenderer renderer = HtmlRenderer.builder().build();\n" +
                "        String htmltext = renderer.render(document);// \"<p>This is <em>Markdown</em></p>\\n\"\n" +
                "        return htmltext;\n" +
                "    }\n" +
                "~~~");
        System.out.println(s);
    }

    @Test
    void mailTest(){
        Tomail toEmail =new Tomail(new String[]{"2186840198@qq.com"},"欢迎","欢迎您来小站玩");
        mailUtils.sendregisterMessage(toEmail,3951);
    }
}
