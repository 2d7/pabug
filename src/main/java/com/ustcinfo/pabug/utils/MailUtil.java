package com.ustcinfo.pabug.utils;

import com.ustcinfo.pabug.bean.MailBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

@Component
@Slf4j(topic = "mail")
public class MailUtil {
    @Autowired
    JavaMailSender mailSender;
    @Autowired
    MailProperties mailProperties;

    public void sendMail(MailBean mailBean) {
        SimpleMailMessage mimeMessage =new SimpleMailMessage();
        mimeMessage.setFrom(mailProperties.getUsername());
        mimeMessage.setTo(mailBean.getToAccount());
        mimeMessage.setSubject(mailBean.getSubject());
        mimeMessage.setText(mailBean.getContent());
        mailSender.send(mimeMessage);
        log.info("已发送邮件");
    }
    /**
     * 发送邮件-附件邮件
     * @param mailBean
     */
    public boolean send(MailBean mailBean) {
        try {
            MimeMessage mimeMessage =mailSender.createMimeMessage();
            MimeMessageHelper helper =new MimeMessageHelper(mimeMessage, true);
            helper.setFrom(mailProperties.getUsername());
            String[] setto = mailBean.getToAccount().split(",");
            helper.setTo(setto);
            helper.setSubject(mailBean.getSubject());
            helper.setText(mailBean.getContent(), true);
            mailSender.send(mimeMessage);
            return true;
        }catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }
}