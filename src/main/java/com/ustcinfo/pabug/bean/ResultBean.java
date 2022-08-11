package com.ustcinfo.pabug.bean;
import lombok.Data;
@Data
public class ResultBean {
    private long id;
    private String title;
    private String link;
    private String text;
    private String date;
    private String keyword;
    private String byFrom;
    private String byFromUrl;

    @Override
    public String toString() {
        return "ResultBean{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", link='" + link + '\'' +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                ", keyword='" + keyword + '\'' +
                ", byFrom='" + byFrom + '\'' +
                ", byFromUrl='" + byFromUrl + '\'' +
                '}';
    }
}

