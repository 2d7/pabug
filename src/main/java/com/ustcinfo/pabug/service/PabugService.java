package com.ustcinfo.pabug.service;

import com.ustcinfo.pabug.bean.ResultBean;
import com.ustcinfo.pabug.bean.SiteBean;
import com.ustcinfo.pabug.dao.ResultMapper;
import com.ustcinfo.pabug.dao.SiteMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
@Service
@Slf4j(topic = "pabug")
public class PabugService {
    @Autowired
    private Rules rules;
    @Autowired
    private SiteMapper siteMapper;
    @Autowired
    private ResultMapper resultMapper;
    public void insertResult(){
        List<SiteBean> siteBeans = siteMapper.getAllSite();
        int count = 0;
        for(SiteBean siteBean:siteBeans){
            //爬取结果
            //1.检查是否更新
            ResultBean last = resultMapper.getLastestResultBySite(siteBean.getName());
            List<ResultBean> list = rules.getRules(siteBean,last);
            Collections.reverse(list);
            for(ResultBean e: list){
                //插入数据库
                e.setText(e.getText().substring(0,e.getText().length()>4900?4900:e.getText().length()));
                resultMapper.addResult(e);
                log.info("正在保存{}",e.getTitle());
                //是否发邮件
                if(e.getKeyword()!=null&&e.getKeyword().length()>0){
                    resultMapper.addMail(e);
                    count++;
                }
            }
            log.info("此次缓存后爬取了----{}",siteBean.getName());
        }
        log.info("此次缓存后，一共有{}条待发数据",count);
        log.info("当前数据库一共有 {} 条待发邮件",resultMapper.getReadyMail().size());
    }

}
//1.给出连接，设定规则 url
//2.获取bean

//        Validate.isTrue(args.length == 1, "usage: supply url to fetch");
//        String url = "http://jx.ah.gov.cn";
//        String url = "http://kjt.ah.gov.cn/kjzx/tzgg/index.html";
//        String url = "http://fzggw.ah.gov.cn";
//        String url = "http://commerce.ah.gov.cn";//反爬
//        String url = "http://sjzyj.ah.gov.cn";
//        String url = "http://kjj.hefei.gov.cn/index.html";//反爬
//        String url = "http://drc.hefei.gov.cn";//反爬
//        String url = "http://jxj.hefei.gov.cn";//反爬
//        String url = "http://swj.hefei.gov.cn";//反爬
//        String url = "http://sjzyj.hefei.gov.cn";//反爬
//        String url = "http://gxq.hefei.gov.cn";//反爬
//        String url = "http://jxj.hefei.gov.cn/tzgg/index.html";
//        HttpClient httpClient = HttpClientBuilder.create().build();
//        HttpGet httpGet = new HttpGet(url);
//        httpGet.setHeader("Host", "jxj.hefei.gov.cn");
//        httpGet.setHeader("User-Agent", "Mozilla/5.0 (Macintosh; Intel Mac OS X 10.13; rv:73.0) Gecko/20100101 Firefox/73.0");
//        httpGet.setHeader("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//        httpGet.setHeader("Accept-Language", "zh-CN,zh;q=0.8,zh-TW;q=0.7,zh-HK;q=0.5,en-US;q=0.3,en;q=0.2");
//        httpGet.setHeader("Accept-Encoding", "gzip, deflate");
//        httpGet.setHeader("Connection", "keep-alive");
//        httpGet.setHeader("Referer", "http://jxj.hefei.gov.cn/tzgg/index.html");
//        httpGet.setHeader("Cookie", "__jsluid_h=06f604334a477a3518767536e6c72dce; __jsl_clearance=1611556282.528|0|bit8StKhcvinDbYPWlOnp7ZNnU8%3D; hefei_gove_SHIROJSESSIONID=d282fc99-99cd-4e1c-8c78-513ff130029e");
//        httpGet.setHeader("Upgrade-Insecure-Requests", "1");
//
//
//        HttpResponse httpResponse = httpClient.execute(httpGet);
//        HttpEntity resEntity = httpResponse.getEntity();
//        String strResponse = EntityUtils.toString(resEntity, "utf-8");
//        System.out.println(strResponse);
