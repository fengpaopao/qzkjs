package com.qzsq.article.mapper;

import com.qzsq.article.entity.Article;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/12 16:20
 * 社区公告
 * 4
 */
@Component
public interface GrassrootsopenMapper {
    //查询政策法规的标题和时间
    List<Article> getTitlego();


}
