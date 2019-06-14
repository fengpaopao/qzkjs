package com.qzsq.article.service.serviceImpol;

import com.qzsq.article.dao.BulletinDao;
import com.qzsq.article.entity.Article;
import com.qzsq.article.service.BulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/12 16:20
 * 4
 */
@Service
public class BulletinServiceImpol implements BulletinService {
    @Autowired
    BulletinDao bulletinDao;

    //查询社区公告的6条数据
    @Override
    public List<Article> getTitleEleven() {
        return bulletinDao.getTitleEleven();
    }
}
