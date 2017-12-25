package com.caox.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

/**
 * Created by summer on 2017/5/4.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {

    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail("jn_caoxia@163.com","test simple mail"," hello this is simple mail");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String content="<html>\n" +
                "<body>\n" +
                "    <h3>hello world ! 这是一封html邮件!</h3>\n" +
                "</body>\n" +
                "</html>";
        mailService.sendHtmlMail("jn_caoxia@163.com","test simple mail",content);
    }

    /**
     * 带附件的邮件发送
     */
    @Test
    public void sendAttachmentsMail() {
        String filePath="D:\\data\\baofoo4\\admin\\app.properties";
        mailService.sendAttachmentsMail("jn_caoxia@163.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }

    /**
     * 带图片的邮件发送(静态资源)
     */
    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content="<html><body>这是有图片的邮件：<img src=\'cid:" + rscId + "\' ></body></html>";
        String imgPath = "C:\\Users\\Public\\Pictures\\Sample Pictures\\app.jpg";

        mailService.sendInlineResourceMail("jn_caoxia@163.com", "主题：这是有图片的邮件", content, imgPath, rscId);
    }


    @Test
    public void sendTemplateMail() {
        //创建邮件正文
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);

        mailService.sendHtmlMail("jn_caoxia@163.com","主题：这是模板邮件",emailContent);
    }
}
