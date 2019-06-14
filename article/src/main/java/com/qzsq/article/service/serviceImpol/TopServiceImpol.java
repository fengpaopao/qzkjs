package com.qzsq.article.service.serviceImpol;

import com.qzsq.article.dao.ResponsibilityDao;
import com.qzsq.article.dao.TopDao;
import com.qzsq.article.entity.Article;
import com.qzsq.article.service.ResponsibilityService;
import com.qzsq.article.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/13 15:25
 * 4
 */
@Service
public class TopServiceImpol implements TopService {
    @Autowired
    TopDao topDao;

    //查询政策法规的标题
    @Override
    public Article gettop() {
        return topDao.gettop();
    }


}
