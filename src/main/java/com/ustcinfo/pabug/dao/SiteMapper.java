package com.ustcinfo.pabug.dao;

import com.ustcinfo.pabug.bean.SiteBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SiteMapper {

    SiteBean getSiteByid(int id);
    List<SiteBean> getAllSite();
}