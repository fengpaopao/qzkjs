package com.qzsq.article.controller;

import com.qzsq.article.entity.Article;
import com.qzsq.article.entity.ResponseCode;
import com.qzsq.article.service.GrassrootsopenService;
import com.qzsq.article.service.ResponsibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/12 16:18
 * j基层公开控制器
 * 4
 */
@RestController
@RequestMapping("/go")
public class GrassrootsopenControllr {
    @Autowired
    GrassrootsopenService grassrootsopenService;


    /**
     * @return 查询基层公开的标题
     * @Author ffc
     * @Description //TODO
     * @Date 2019/6/12
     * @Param * @param
     **/
    @RequestMapping("/getTitlego")
    public ResponseCode getTitleEleven() {
        List<Article> articles = grassrootsopenService.getTitlego();
        ResponseCode ok = ResponseCode.OK();
        ok.getDate().put("bulletin", articles);
        return ok;
    }


}
