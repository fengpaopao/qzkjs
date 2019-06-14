package com.qzsq.article.mapper;

import com.qzsq.article.entity.Article;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/13 15:26
 * 4
 */
@Component
public interface CadreworkMapper {
    List<Article> getTitlecw();

}
