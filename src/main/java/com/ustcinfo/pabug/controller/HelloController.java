package com.ustcinfo.pabug.controller;

import com.ustcinfo.pabug.bean.SiteBean;
import com.ustcinfo.pabug.service.PabugService;
import com.ustcinfo.pabug.service.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Autowired
    private SiteService siteService;
    @Autowired
    private PabugService pabugService;
    @RequestMapping("insertResult")
    @ResponseBody
    public void insertResult(){
        pabugService.insertResult();
    }

    @RequestMapping("getSiteById")
    @ResponseBody
    public SiteBean get(){
        return siteService.getSiteByid(1);
    }

}
