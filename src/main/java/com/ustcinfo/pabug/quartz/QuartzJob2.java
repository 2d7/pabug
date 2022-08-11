package com.ustcinfo.pabug.quartz;

import com.ustcinfo.pabug.bean.ConfigBean;
import com.ustcinfo.pabug.bean.MailBean;
import com.ustcinfo.pabug.bean.ResultBean;
import com.ustcinfo.pabug.service.PabugService;
import com.ustcinfo.pabug.utils.DicUtils;
import com.ustcinfo.pabug.utils.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * 爬取网站的定时任务
 */
@Slf4j(topic = "job")
public class QuartzJob2 extends QuartzJobBean {
    @Autowired
    MailUtil mailUtil;
    @Autowired
    ConfigBean configBean;
    @Autowired
    PabugService pabugService;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("执行爬虫任务开始....");
        pabugService.insertResult();
    }

}