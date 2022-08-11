package com.ustcinfo.pabug.dao;

import com.ustcinfo.pabug.bean.ResultBean;
import com.ustcinfo.pabug.bean.SiteBean;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultMapper {

    int addResult(ResultBean resultBean);
    ResultBean getLastestResultBySite(String name);
    int addMail(ResultBean resultBean);
    List<ResultBean> getReadyMail();
    int updateMailStatus(long id);

}