package com.qzsq.article.controller;

import com.qzsq.article.entity.Article;
import com.qzsq.article.entity.ResponseCode;
import com.qzsq.article.service.BulletinService;
import com.qzsq.article.service.CadreworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 2 * @Author: ffc
 * 3 * @Date: 2019/6/12 16:18
 * 干部干作公告控制器
 * 4
 */
@RestController
@RequestMapping("/cw")
public class CadreworkControllr {
    @Autowired
    CadreworkService cadreworkService;


    /**
     * @return 查询干部干作的十一标题
     * @Author ffc
     * @Description //TODO
     * @Date 2019/6/12
     * @Param * @param
     **/
    @RequestMapping("/getTitlecw")
    public ResponseCode getTitleEleven() {
        List<Article> articles = cadreworkService.getTitlecw();
        ResponseCode ok = ResponseCode.OK();
        ok.getDate().put("bulletin", articles);
        return ok;
    }


}
