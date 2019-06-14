package com.qzsq.article.dao;

import com.alibaba.druid.util.StringUtils;
import com.qzsq.article.entity.Article;
import com.qzsq.article.mapper.CadreworkMapper;
import com.qzsq.article.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/13 15:26
 * 4
 */
@Component
public class CadreworkDao {
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    CadreworkMapper cadreworkMapper;

    public List<Article> getTitlecw() {
        List<Article> titleEleven = null;
        //从redis中查询数据
        String article = stringRedisTemplate.opsForValue().get("article-cw");
        if (!(StringUtils.isEmpty(article))) {
            //进行反序列化
            titleEleven = (List<Article>) MyUtil.deserial(article);
            return titleEleven;
        }
        //数据库查询
        titleEleven = cadreworkMapper.getTitlecw();
        if (titleEleven != null) {
            //序列化
            String serial = MyUtil.serial(titleEleven);
            //放入缓存
            stringRedisTemplate.opsForValue().set("article-cw", serial);
        }
        return titleEleven;
    }
}
