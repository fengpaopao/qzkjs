package com.qzsq.article.service.serviceImpol;

import com.qzsq.article.dao.CadreworkDao;
import com.qzsq.article.entity.Article;
import com.qzsq.article.service.CadreworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/13 15:25
 * 4
 */
@Service
public class CadreworkServiceImpol implements CadreworkService {
    @Autowired
    CadreworkDao cadreworkDao;

    //查询干部干作的标题
    @Override
    public List<Article> getTitlecw() {
        return cadreworkDao.getTitlecw();
    }
}
