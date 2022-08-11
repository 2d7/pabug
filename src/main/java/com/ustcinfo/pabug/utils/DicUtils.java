package com.ustcinfo.pabug.utils;

import com.ustcinfo.pabug.bean.ResultBean;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
@Slf4j(topic = "util")
public class DicUtils {
//    public static List<ResultBean> cacheResult=new ArrayList<>();
    public static Document getResourceDoc(int isUnti,String url,String driverPath){
        log.info("开始连接爬取网站...");
        WebDriver driver =null;
        Document doc =null;
        try {
            if(isUnti==0){
                log.info("直接连接...{}",url);
                doc = Jsoup.connect(url).get();
            }else {
                log.info("反爬连接...{}",url);
                //下载的chromedriver位置
                System.setProperty("webdriver.chrome.driver",driverPath);
                //实例化ChromeDriver对象
                ChromeOptions chromeOptions=new ChromeOptions();
                chromeOptions.addArguments("--headless");
                chromeOptions.addArguments("blink-settings=imagesEnabled=false");
                driver = new ChromeDriver(chromeOptions);
                //打开指定网站
                try{
                    driver.get(url);
                }catch(Exception e){
                    log.info("访问出错：{}",e.getMessage());
                }

                //解析页面
                WebDriverWait wait = new WebDriverWait(driver, 60);//初始化等待60s
                wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("a")));//等待xx元素出现
                String pageSource =driver.getPageSource();
                doc = Jsoup.parse(pageSource);
            }
            return doc;
        } catch (IOException e) {
            log.info("访问出错");
            e.printStackTrace();
            return DicUtils.getResourceDoc(isUnti,url,driverPath);
        }finally {
            if(driver!=null){
                driver.close();
                driver.quit();
            }
        }
    }
}
