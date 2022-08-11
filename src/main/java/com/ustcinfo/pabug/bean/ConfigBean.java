package com.ustcinfo.pabug.bean;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@ConfigurationProperties(prefix = "var")
public class ConfigBean {
//    @Value("${var.mail}")
    private String mail;
//    @Value("${var.cron}")
    private String cron;
//    @Value("${var.cron2}")
    private String cron2;
    private String driverPath;
//    @Value("${var.keyword}")
    private List<String> keyword;
}
