package com.qzsq.article.dao;

import com.alibaba.druid.util.StringUtils;
import com.qzsq.article.entity.Article;
import com.qzsq.article.mapper.PoliciesregulationsMapper;
import com.qzsq.article.mapper.ResponsibilityMapper;
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
public class PoliciesregulationsDao {


    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    PoliciesregulationsMapper policiesregulationsMapper;


    //查询责任任免的标题
    public List<Article> getTitlepr() {
        List<Article> titleEleven = null;
        //从redis中查询数据
        String article = stringRedisTemplate.opsForValue().get("article-pr");
        if (!(StringUtils.isEmpty(article))) {
            //进行反序列化
            titleEleven = (List<Article>) MyUtil.deserial(article);
            return titleEleven;
        }
        //数据库查询
        titleEleven = policiesregulationsMapper.getTitlepr();
        if (titleEleven != null) {
            //序列化
            String serial = MyUtil.serial(titleEleven);
            //放入缓存
            stringRedisTemplate.opsForValue().set("article-pr", serial);
        }
        return titleEleven;
    }


}
