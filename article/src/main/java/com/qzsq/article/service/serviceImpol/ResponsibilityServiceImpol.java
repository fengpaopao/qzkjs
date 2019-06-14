package com.qzsq.article.service.serviceImpol;

import com.qzsq.article.dao.NewestinformationDao;
import com.qzsq.article.dao.ResponsibilityDao;
import com.qzsq.article.entity.Article;
import com.qzsq.article.service.NewestinformationService;
import com.qzsq.article.service.ResponsibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/13 15:25
 * 4
 */
@Service
public class ResponsibilityServiceImpol implements ResponsibilityService {
    @Autowired
    ResponsibilityDao responsibilityDao;

    //查询政策法规的标题
    @Override
    public List<Article> getTitleri() {
        return responsibilityDao.getTitleri();
    }
}
