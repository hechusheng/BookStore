package com.xzsd.app.client.commodity.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.client.commodity.entity.CmdAssess;
import com.xzsd.app.client.commodity.service.CmdService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName CmdInfo
 * @Description 查询Commodity
 * @Author hechusheng
 * @Date 2020-04-17
 */
@RestController
@RequestMapping("/clientCommodity")
public class CmdController {
    private static final Logger logger = LoggerFactory.getLogger(CmdController.class);
    @Resource
    private CmdService cmdService;

    /**
     * 商品详情查询
     * @param comCode
     * @return
     */
    @RequestMapping("getCommodity")
    public AppResponse getCommodity (String comCode) {
        try{
            //查询
            return cmdService.getCommodity(comCode);
        }catch (Exception e){
            logger.error("查询商品详情失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品一级分类
     * @return
     */
    @RequestMapping("listFirstClass")
    public AppResponse listFirstClass () {
        try{
            //查询
            return cmdService.listFirstClass();
        }catch (Exception e){
            logger.error("查询商品一级分类失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询二级分类及其商品信息
     * @param firstSortCode
     * @return
     */
    @RequestMapping("listSecondClass")
    public AppResponse listSecondClass (String firstSortCode) {
        try{
            //查询
            return cmdService.listSecondClass(firstSortCode);
        }catch (Exception e){
            logger.error("查询二级分类及其商品信息失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询商品评价列表(分页)
     * @param cmdAssess
     * @return
     */
    @RequestMapping("listCommodityAssessByPage")
    public AppResponse listCommodityAssessByPage (CmdAssess cmdAssess) {
        try{
            //查询商品评价
            return cmdService.listCommodityAssessByPage(cmdAssess);
        }catch (Exception e){
            logger.error("查询二级分类及其商品信息失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
