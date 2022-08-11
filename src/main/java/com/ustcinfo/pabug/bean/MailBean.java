package com.ustcinfo.pabug.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import java.io.File;

@Data
@PropertySource(value = "classpath:mail.properties")
public class MailBean {

private String subject;
    private String content;
    private String toAccount;
    private File attachmentFile;
    private String attachmentFileName;
}