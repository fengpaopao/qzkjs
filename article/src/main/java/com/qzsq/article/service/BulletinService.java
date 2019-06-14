package com.qzsq.article.service;

import com.qzsq.article.entity.Article;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/12 16:20
 * 社区公告
 * 4
 */
@Service
public interface BulletinService {
    //查询社区公告的标题和时间
    List<Article> getTitleEleven();


}
