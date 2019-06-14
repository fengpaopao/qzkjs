package com.qzsq.article.service.serviceImpol;

import com.qzsq.article.dao.GrassrootsopenDao;
import com.qzsq.article.dao.ResponsibilityDao;
import com.qzsq.article.entity.Article;
import com.qzsq.article.service.GrassrootsopenService;
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
public class GrassrootsopenServiceImpol implements GrassrootsopenService {
    @Autowired
    GrassrootsopenDao grassrootsopenDao;

    //查询基层公开的标题
    @Override
    public List<Article> getTitlego() {
        return grassrootsopenDao.getTitlego();
    }
}
