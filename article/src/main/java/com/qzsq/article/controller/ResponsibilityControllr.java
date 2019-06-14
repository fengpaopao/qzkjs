package com.qzsq.article.controller;

import com.qzsq.article.entity.Article;
import com.qzsq.article.entity.ResponseCode;
import com.qzsq.article.service.NewestinformationService;
import com.qzsq.article.service.ResponsibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/12 16:18
 * 政策法规控制器
 * 4
 */
@RestController
@RequestMapping("/ri")
public class ResponsibilityControllr {
    @Autowired
    ResponsibilityService responsibilityService;


    /**
     * @return 查询政策法规的标题
     * @Author ffc
     * @Description //TODO
     * @Date 2019/6/12
     * @Param * @param
     **/
    @RequestMapping("/getTitleri")
    public ResponseCode getTitleEleven() {
        List<Article> articles = responsibilityService.getTitleri();
        ResponseCode ok = ResponseCode.OK();
        ok.getDate().put("bulletin", articles);
        return ok;
    }


}
