package com.qzsq.article.dao;

import com.alibaba.druid.util.StringUtils;
import com.qzsq.article.entity.Article;
import com.qzsq.article.entity.ResponseCode;
import com.qzsq.article.mapper.NewestinformationMapper;
import com.qzsq.article.mapper.PartynewsMapper;
import com.qzsq.article.service.PartynewsService;
import com.qzsq.article.util.MyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/12 16:18
 * 干部干作公告控制器
 * 4
 */
@Component
public class NewestinformationDao {


    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    NewestinformationMapper newestinformationMapper;


    //查询最新资讯的标题
    public List<Article> getTitleni() {
        List<Article> titleEleven = null;
        //从redis中查询数据
        String article = stringRedisTemplate.opsForValue().get("article-ni");
        if (!(StringUtils.isEmpty(article))) {
            //进行反序列化
            titleEleven = (List<Article>) MyUtil.deserial(article);
            return titleEleven;
        }
        //数据库查询
        titleEleven = newestinformationMapper.getTitleni();
        if (titleEleven != null) {
            //序列化
            String serial = MyUtil.serial(titleEleven);
            //放入缓存
            stringRedisTemplate.opsForValue().set("article-ni", serial);
        }
        return titleEleven;
    }


}
