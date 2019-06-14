package com.qzsq.article.controller;

import com.qzsq.article.entity.Article;
import com.qzsq.article.entity.ResponseCode;
import com.qzsq.article.service.BulletinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/12 16:18
 * 社区公告控制器
 * 4
 */
@RestController
@RequestMapping("/ca")
public class BulletinControllr {
    @Autowired
    BulletinService bulletinService;


    /**
     * @return 查询社区公告的十一标题
     * @Author ffc
     * @Description //TODO
     * @Date 2019/6/12
     * @Param * @param
     **/
    @RequestMapping("/getTitleEleven")
    public ResponseCode getTitleEleven() {
        List<Article> articles = bulletinService.getTitleEleven();
        ResponseCode ok = ResponseCode.OK();
        ok.getDate().put("bulletin", articles);
        return ok;
    }


}
