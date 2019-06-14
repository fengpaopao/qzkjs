package com.qzsq.article.service.serviceImpol;

import com.qzsq.article.dao.NewestinformationDao;
import com.qzsq.article.dao.PartynewsDao;
import com.qzsq.article.entity.Article;
import com.qzsq.article.service.NewestinformationService;
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
public class NewestinformationServiceImpol implements NewestinformationService {
    @Autowired
    NewestinformationDao newestinformationDaok;

    //查询最新资讯的标题
    @Override
    public List<Article> getTitleni() {
        return newestinformationDaok.getTitleni();
    }
}
