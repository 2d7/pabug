package com.ustcinfo.pabug.service;

import com.ustcinfo.pabug.bean.ConfigBean;
import com.ustcinfo.pabug.bean.ResultBean;
import com.ustcinfo.pabug.bean.SiteBean;
import com.ustcinfo.pabug.utils.DicUtils;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Rules {
    @Autowired
    private ConfigBean configBean;

    public List<ResultBean> getRules(SiteBean siteBean,ResultBean last){
        Document doc = DicUtils.getResourceDoc(siteBean.getIsUnti(),siteBean.getUrl(),configBean.getDriverPath());
        // 获取文章列表
        Elements uls = doc.getElementsByClass(siteBean.getUlClass());
        List<ResultBean> siteBeans = new ArrayList<>();
        ResultBean resultBean = null;
        for(Element ul : uls){
            Elements lis = ul.select("li");
            for (Element li : lis){
                resultBean = new ResultBean();
                resultBean.setByFromUrl(siteBean.getUrl());
                resultBean.setByFrom(siteBean.getName());
                Elements dates = li.getElementsByClass(siteBean.getDateClass());
                for(Element date : dates){
                    resultBean.setDate(date.text());
                }
                Elements links = li.select("a[href]");
                //遇到脏内容跳过此次遍历
                if(links.size()==0){
                    continue;
                }
                for (Element link : links) {
                    resultBean.setLink(link.attr("abs:href"));
                    resultBean.setTitle(link.text());
                }
                //如果此标题已经存在则不再遍历
                if(last!=null&&last.getTitle().equals(resultBean.getTitle())){
                    break;
                }
                Document text = DicUtils.getResourceDoc(siteBean.getIsUnti(),resultBean.getLink(),configBean.getDriverPath());
                Elements textEles = text.getElementsByClass(siteBean.getTextClass());
                StringBuffer sb = new StringBuffer();
                for(Element textEl : textEles){
                    sb.append(textEl.text());
                }
                resultBean.setText(sb.toString());
                StringBuffer key = new StringBuffer();
                for(String e : configBean.getKeyword()){
                    if(resultBean.getText().indexOf(e)>0||resultBean.getTitle().indexOf(e)>0){
                        key.append(e+"、");
                    }
                }
                if(key.length()>0){
                    resultBean.setKeyword(key.substring(0,key.length()-1));
                }
                siteBeans.add(resultBean);
            }
        }
        return siteBeans;
    }
}
