package com.qzsq.article.controller;

import com.qzsq.article.entity.Article;
import com.qzsq.article.entity.ResponseCode;
import com.qzsq.article.service.CadreworkService;
import com.qzsq.article.service.PartynewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/12 16:18
 * 党建新闻公告控制器
 * 4
 */
@RestController
@RequestMapping("/pn")
public class PartynewsControllr {
    @Autowired
    PartynewsService partynewsService;


    /**
     * @return 查询党建新闻的十一标题
     * @Author ffc
     * @Description //TODO
     * @Date 2019/6/12
     * @Param * @param
     **/
    @RequestMapping("/getTitlepn")
    public ResponseCode getTitleEleven() {
        List<Article> articles = partynewsService.getTitlepn();
        ResponseCode ok = ResponseCode.OK();
        ok.getDate().put("bulletin", articles);
        return ok;
    }


}
