package com.qzsq.article.controller;

import com.qzsq.article.entity.Article;
import com.qzsq.article.entity.ResponseCode;
import com.qzsq.article.service.ResponsibilityService;
import com.qzsq.article.service.TopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/12 16:18
 * 置顶的控制器
 * 4
 */
@RestController
@RequestMapping("/top")
public class TopControllr {
    @Autowired
    TopService topService;


    /**
     * @return 查询置顶的文章的标题
     * @Author ffc
     * @Description //TODO
     * @Date 2019/6/12
     * @Param * @param
     **/
    @RequestMapping("/gettop")
    public ResponseCode getTitleEleven() {
        Article articles = topService.gettop();
        ResponseCode ok = ResponseCode.OK();
        ok.getDate().put("bulletin", articles);
        return ok;
    }


}
