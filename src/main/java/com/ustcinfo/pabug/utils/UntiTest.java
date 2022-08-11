package com.ustcinfo.pabug.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UntiTest {
    public static void main(String[] args) {
        Document doc =null;
        List<String> urllist = new ArrayList<>();
        urllist.add("http://jx.ah.gov.cn/sy/wjgg/index.html");//安徽省经信厅 0
        urllist.add("http://kjt.ah.gov.cn/kjzx/tzgg/index.html");//安徽省科技厅 0
        urllist.add("http://fzggw.ah.gov.cn/content/column/49637171");//安徽省发改委 0
        urllist.add("http://commerce.ah.gov.cn/public/column/21711?type=4&catId=28010341&action=list");//安徽省商务厅 1
        urllist.add("http://sjzyj.ah.gov.cn/xwdt/gsgg/index.html");//安徽省数据资源管理局 0
        urllist.add("http://kjj.hefei.gov.cn/zwgk/tzgg/index.html");//合肥市科技局 1
        urllist.add("http://drc.hefei.gov.cn/zxdt/tzgg/index.html");//合肥市发改委 1
        urllist.add("http://jxj.hefei.gov.cn/tzgg/index.html");//合肥市经信局 1
        urllist.add("http://swj.hefei.gov.cn/swdt/tzfb/index.html");//合肥市商务局 1
        urllist.add("http://sjzyj.hefei.gov.cn/fwdh/tzgg/index.html");//合肥市数据资源局 1
        urllist.add("http://gxq.hefei.gov.cn/tzgg/index.html");//合肥市高新区管委会 1
        for (String url : urllist){
            try {
                System.out.println(url);
                doc = Jsoup.connect(url).get();
                System.out.println(doc.text());
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }

    }
}
