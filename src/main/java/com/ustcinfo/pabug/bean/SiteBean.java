package com.ustcinfo.pabug.bean;

import lombok.Data;
@Data
public class SiteBean{
    private long id;
    //是否反爬
    private int isUnti;
    //网站名
    private String name;
    //网站地址
    private String url;
    //新闻区域标签
    private String ulClass;
    //新闻日期标签
    private String dateClass;
    //新闻正文
    private String textClass;
    private int isUse;
    @Override
    public String toString() {
        return "SiteBean{" +
                "isUnti=" + isUnti +
                ", name='" + name + '\'' +
                ", url='" + url + '\'' +
                ", ulClass='" + ulClass + '\'' +
                ", dateClass='" + dateClass + '\'' +
                ", textClass='" + textClass + '\'' +
                '}';
    }
}
