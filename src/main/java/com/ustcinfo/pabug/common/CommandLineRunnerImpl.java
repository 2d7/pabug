package com.ustcinfo.pabug.common;

import com.ustcinfo.pabug.service.PabugService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j(topic = "start...")
public class CommandLineRunnerImpl implements CommandLineRunner {
    @Autowired
    private PabugService pabugService;
    @Override
    public void run(String... args) throws Exception {
        pabugService.insertResult();
    }
}