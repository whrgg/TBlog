package com.traveller.blogcms;

import com.alibaba.druid.support.json.JSONUtils;
import com.traveller.entity.User;
import com.traveller.mapper.UserMapper;
import com.traveller.properties.JwtProperties;
import com.traveller.utils.MarkdownUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@SpringBootTest
class BlogCmsApplicationTests {


    @Autowired
    UserMapper userMapper;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    JwtProperties jwtProperties;

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
    void getUser(){

        User traveller = userMapper.selectUserByUsername("traveller");

        System.out.println(traveller);
    }

    @Test
    void saveUser(){
        Date date = Date.from(LocalDateTime.now().toInstant(ZoneOffset.UTC));
        User user =new User(null,"traveller", passwordEncoder.encode("Mysqltest"),"可爱捏",
                date,date,"湖南常德","email","img","admin");
        userMapper.insert(user);
        System.out.println(user);

    }

    @Test
    void properties(){
        System.out.println(jwtProperties);
    }
}
