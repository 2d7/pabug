package com.ustcinfo.pabug;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan("com.ustcinfo.pabug.dao")
@SpringBootApplication
public class PabugApplication {

    public static void main(String[] args) {
        SpringApplication.run(PabugApplication.class, args);
    }

}
