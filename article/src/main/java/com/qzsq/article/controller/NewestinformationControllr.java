package com.qzsq.article.controller;

import com.qzsq.article.entity.Article;
import com.qzsq.article.entity.ResponseCode;
import com.qzsq.article.service.NewestinformationService;
import com.qzsq.article.service.PartynewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/12 16:18
 * 最新资讯控制器
 * 4
 */
@RestController
@RequestMapping("/ni")
public class NewestinformationControllr {
    @Autowired
    NewestinformationService newestinformationService;


    /**
     * @return 查询最新资讯的标题
     * @Author ffc
     * @Description //TODO
     * @Date 2019/6/12
     * @Param * @param
     **/
    @RequestMapping("/getTitleni")
    public ResponseCode getTitleEleven() {
        List<Article> articles = newestinformationService.getTitleni();
        ResponseCode ok = ResponseCode.OK();
        ok.getDate().put("bulletin", articles);
        return ok;
    }


}
