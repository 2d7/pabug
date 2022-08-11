package com.ustcinfo.pabug.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class chrome {
 
  public static void main(String[] args) {
    //下载的chromedriver位置
    System.setProperty("webdriver.chrome.driver","A:\\temp\\chromedriver.exe");
    //实例化ChromeDriver对象
    ChromeOptions chromeOptions=new ChromeOptions();
    chromeOptions.addArguments("-headless");
    WebDriver driver = new ChromeDriver(chromeOptions);
//    JavascriptExecutor jse = (JavascriptExecutor)driver;
    String url="http://jxj.hefei.gov.cn/tzgg/index.html";
    //打开指定网站
    driver.get(url);

    //定义选择器规则
//    String rule="#resultList > div:nth-child(4) > p > span > a";
    //通过选择器拿到元素
//    Elements select = jsoup.select(rule);
//    String s=select.text();
    //解析页面
    try {
      Thread.sleep(1500);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
    String pageSource =driver.getPageSource();
    System.out.println(pageSource);
    Document jsoup = Jsoup.parse(pageSource);
    Elements elements = jsoup.select("script");
//    for (Element e:elements){
//      jse.executeScript(e.data());
//    }
    //关闭
//    driver.close();
//    driver.quit();
//    Elements links = jsoup.select("a[href]");
//    print("\nLinks: (%d)", links.size());
//    for (Element link : links) {
//      print(" * a: <%s>  (%s)", link.attr("abs:href"), trim(link.text(), 35));
//    }
     
  }
}