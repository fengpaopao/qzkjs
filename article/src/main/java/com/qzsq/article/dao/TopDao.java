package com.qzsq.article.dao;

import com.alibaba.druid.util.StringUtils;
import com.qzsq.article.entity.Article;
import com.qzsq.article.mapper.ResponsibilityMapper;
import com.qzsq.article.mapper.TopMapper;
import com.qzsq.article.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/12 16:18
 * 政策法规公告控制器
 * 4
 */
@Component
public class TopDao {


    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    TopMapper topMapper;


    //查询置顶消息
    public Article gettop() {
        Article article = null;
        //从redis里面查
        String s = stringRedisTemplate.opsForValue().get("article-top");
        if (!(StringUtils.isEmpty(s))) {
            article = (Article) MyUtil.deserial(s);
            return article;
        }
        article = topMapper.gettop();
        if (article != null) {
            stringRedisTemplate.opsForValue().set("article-top", MyUtil.serial(article));
            return article;
        }
        return null;
    }
}
