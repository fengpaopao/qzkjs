package com.qzsq.article.service.serviceImpol;

import com.qzsq.article.dao.CadreworkDao;
import com.qzsq.article.dao.PartynewsDao;
import com.qzsq.article.entity.Article;
import com.qzsq.article.service.CadreworkService;
import com.qzsq.article.service.PartynewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/13 15:25
 * 4
 */
@Service
public class PartynewsServiceImpol implements PartynewsService {
    @Autowired
    PartynewsDao partynewsDao;

    //查询党建新闻的标题
    @Override
    public List<Article> getTitlepn() {
        return partynewsDao.getTitlepn();
    }
}
