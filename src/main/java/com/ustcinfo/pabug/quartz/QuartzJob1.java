package com.ustcinfo.pabug.quartz;

import com.ustcinfo.pabug.bean.ConfigBean;
import com.ustcinfo.pabug.bean.MailBean;
import com.ustcinfo.pabug.bean.ResultBean;
import com.ustcinfo.pabug.dao.ResultMapper;
import com.ustcinfo.pabug.utils.DicUtils;
import com.ustcinfo.pabug.utils.MailUtil;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;
import sun.java2d.pipe.SpanShapeRenderer;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Slf4j(topic = "job")
public class QuartzJob1 extends QuartzJobBean {
    @Autowired
    MailUtil mailUtil;
    @Autowired
    ConfigBean configBean;
    @Autowired
    ResultMapper resultMapper;
    @Override
    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("执行发送邮件开始....");
        List<ResultBean> list = resultMapper.getReadyMail();
        if(list.size()>0){
            StringBuilder content = new StringBuilder("<html><head></head><body><h2>尊敬的各位领导您们好：</h2><h3>&nbsp;&nbsp;这里是收集到的最新资讯请查收，祝您工作愉快</h3>");
            content.append("<table border=\"5\" style=\"border:solid 1px #E8F2F9;font-size=14px;;font-size:16px; padding:2px\">");
            content.append("<tr style=\"background-color: #428BCA; color:#ffffff\"><th>标题</th><th>来源</th><th>关键字</th><th>时间</th></tr>");
            int countMail =0;
            for (ResultBean e : list) {
                content.append("<tr>");
                content.append("<td style='padding: 5px;'><a href='"+e.getLink()+"'>" +e.getTitle()+"</a></td>");
                content.append("<td style='padding: 5px;'>" + e.getByFrom() + "</td>");
                content.append("<td style='padding: 5px;'>" + e.getKeyword() + "</td>");
                content.append("<td style='padding: 5px;'>" + e.getDate() + "</td>");
                content.append("</tr>");
                countMail++;
            }
            content.append("</table>");
            content.append("</body></html>");
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
            String subject = sdf.format(new Date())+"的资讯汇总";
            MailBean mailBean =new MailBean ();
            mailBean.setToAccount(configBean.getMail());
            mailBean.setSubject(subject);
            mailBean.setContent(content.toString());
            try {
                log.info("本次邮件应包含{}条新闻",countMail);
                log.info("内容为{}",content);
                mailUtil.send(mailBean);
                int countDB = 0;
                for(ResultBean e:list){
                    resultMapper.updateMailStatus(e.getId());
                    countDB++;
                }
                log.info("本次修改数据库条数为：{}条",countDB);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

//        ResultBean resultBean = new ResultBean();
//        resultBean.setTitle("《合肥市大数据应用项目（数据安全风险管控及电子证照 管理平台）第5包项目监理》项目竞争性磋商公告");
//        resultBean.setText("1111111");
//        resultBean.setByFrom("合肥市数据资源局");
//        resultBean.setLink("http://sjzyj.hefei.gov.cn/fwdh/tzgg/18011849.html");
//        resultBean.setDate("2021-01-25");
//        resultBean.setByFromUrl("http://sjzyj.hefei.gov.cn/fwdh/tzgg/index.html");
//        resultBean.setKeyword("大数据");
//        list.add(resultBean);