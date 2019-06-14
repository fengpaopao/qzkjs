package com.qzsq.article.dao;

import com.alibaba.druid.util.StringUtils;
import com.qzsq.article.entity.Article;
import com.qzsq.article.mapper.BulletinMapper;
import com.qzsq.article.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/12 16:21
 * 4
 */
@Component
public class BulletinDao {
    @Autowired
    BulletinMapper bulletinMapper;
    @Autowired
    StringRedisTemplate stringRedisTemplate;


    //查询社区公告的标题共6条数据
    public List<Article> getTitleEleven() {
        List<Article> titleEleven = null;
        //从redis中查询数据
        String article = stringRedisTemplate.opsForValue().get("article-ca");
        if (!(StringUtils.isEmpty(article))) {
            //进行反序列化
            titleEleven = (List<Article>) MyUtil.deserial(article);
            return titleEleven;
        }
        //数据库查询
        titleEleven = bulletinMapper.getTitleEleven();
        if (titleEleven != null) {
            //序列化
            String serial = MyUtil.serial(titleEleven);
            //放入缓存
            stringRedisTemplate.opsForValue().set("article-ca", serial);
        }
        return titleEleven;

    }
}
