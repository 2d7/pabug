package com.ustcinfo.pabug.quartz;

import com.ustcinfo.pabug.bean.ConfigBean;
import com.ustcinfo.pabug.service.PabugService;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
public class QuartzConfig {
    @Autowired
    private ConfigBean configBean;

    /**
     * 邮件发送
     * @return
     */
    @Bean
    public JobDetail jobDetail1(){
        return JobBuilder.newJob(QuartzJob1.class).storeDurably().build();
    }
    @Bean
    public Trigger trigger1(){
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(configBean.getCron());

        return TriggerBuilder.newTrigger()
                .forJob(jobDetail1())
                .withSchedule(cronScheduleBuilder)
                .build();
    }

    /**
     * 网站爬取
     * @return
     */
    @Bean
    public JobDetail jobDetail2(){
        return JobBuilder.newJob(QuartzJob2.class).storeDurably().build();
    }
    @Bean
    public Trigger trigger2(){
        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(configBean.getCron2());

        return TriggerBuilder.newTrigger()
                .forJob(jobDetail2())
                .withSchedule(cronScheduleBuilder)
                .startNow()
                .build();
    }
}