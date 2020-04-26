package com.xzsd.app.client.orderform.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.client.orderform.entity.OrderAssess;
import com.xzsd.app.client.orderform.entity.OrderInfo;
import com.xzsd.app.client.orderform.service.OrderFormService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName  OrderFormController
 * @Description 客户端订单信息控制层
 * @Author hechusheng
 * @Date 2020-04-24
 */
@RestController
@RequestMapping("/clientOrder")
public class OrderFormController {
    private static final Logger logger = LoggerFactory.getLogger(OrderFormController.class);
    @Resource
    private OrderFormService orderFormService;

    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     */
    @RequestMapping("listOrderByPage")
    public AppResponse listOrderByPage(OrderInfo orderInfo){
        try{
            orderInfo.setUserCode(SecurityUtils.getCurrentUserId());
            return orderFormService.listOrderByPage(orderInfo);
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
    @RequestMapping("getOrder")
    public AppResponse getOrder(String orderCode){
        try{
            return orderFormService.getOrder(orderCode);
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    @PostMapping("updateOrderStatus")
    public AppResponse updateOrderStatus(OrderInfo orderInfo){
        try{
            orderInfo.setUpdateUser(SecurityUtils.getCurrentUserId());
            return orderFormService.updateOrderStatus(orderInfo);
        }catch (Exception e){
            logger.error("修改订单状态失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     *
     * @param orderAssess
     * @return
     */
    @PostMapping("addCommodityAssess")
    public AppResponse addCommodityAssess (@RequestBody OrderAssess orderAssess) {
        try{
            String userCode = SecurityUtils.getCurrentUserId();
            orderAssess.setUserCode(userCode);
            orderAssess.setUpdateUser(userCode);
            orderAssess.setCreateUser(userCode);
            return orderFormService.addCommodityAssess(orderAssess);
        }catch (Exception e){
            logger.error("评价失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
