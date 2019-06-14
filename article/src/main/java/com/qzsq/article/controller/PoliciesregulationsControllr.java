package com.qzsq.article.controller;

import com.qzsq.article.entity.Article;
import com.qzsq.article.entity.ResponseCode;
import com.qzsq.article.service.PoliciesregulationsService;
import com.qzsq.article.service.ResponsibilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/12 16:18
 * 责任任免控制器
 * 4
 */
@RestController
@RequestMapping("/pr")
public class PoliciesregulationsControllr {
    @Autowired
    PoliciesregulationsService policiesregulationsService;


    /**
     * @return 查询责任任免的标题
     * @Author ffc
     * @Description //TODO
     * @Date 2019/6/12
     * @Param * @param
     **/
    @RequestMapping("/getTitlepr")
    public ResponseCode getTitleEleven() {
        List<Article> articles = policiesregulationsService.getTitlepr();
        ResponseCode ok = ResponseCode.OK();
        ok.getDate().put("bulletin", articles);
        return ok;
    }


}
