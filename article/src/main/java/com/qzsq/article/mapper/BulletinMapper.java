package com.qzsq.article.mapper;

import com.qzsq.article.entity.Article;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/12 16:20
 * 社区公告
 * 4
 */
@Component
public interface BulletinMapper {
    //查询社区公告的标题和时间
    List<Article> getTitleEleven();


}
