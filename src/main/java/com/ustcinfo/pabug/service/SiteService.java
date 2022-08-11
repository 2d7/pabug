package com.ustcinfo.pabug.service;

import com.ustcinfo.pabug.bean.SiteBean;
import com.ustcinfo.pabug.dao.SiteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SiteService {
    @Autowired
    SiteMapper siteMapper;
    public SiteBean getSiteByid(int id){
        return siteMapper.getSiteByid(id);
    }
    public List<SiteBean> getAllSite(){
        return siteMapper.getAllSite();
    }

}