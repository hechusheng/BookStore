package com.xzsd.app.client.index.controller;

import com.xzsd.app.client.index.service.IndexService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hechusheng
 * @Descritption增删查改IndexController
 * @Date 2020-04-17
 */
@RestController
@RequestMapping("/clientIndex")
public class IndexController {
    private static final Logger logger = LoggerFactory.getLogger(IndexController.class);
    @Resource
    private IndexService indexService;

    /**
     * 查询首页轮播图
     * @return
     */
    @RequestMapping("listCarousel")
    public AppResponse listCarousel () {
        try {
            return indexService.ListCarousel();
        } catch (Exception e) {
            logger.error("查询首页轮播图失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询首页热门商品
     * @return
     */
    @RequestMapping("listCommodityHot")
    public AppResponse listCommodityHot () {
        try {
            return indexService.listCommodityHot();
        } catch (Exception e) {
            logger.error("查询首页热门商品失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
