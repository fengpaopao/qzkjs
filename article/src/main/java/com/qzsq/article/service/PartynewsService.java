package com.qzsq.article.service;

import com.qzsq.article.entity.Article;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/13 15:25
 * 4
 */
@Service
public interface PartynewsService {
    //查询党建新闻标题
    List<Article> getTitlepn();

}
