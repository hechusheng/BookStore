package com.xzsd.app.manager.order.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.manager.order.entity.ManageOrder;
import com.xzsd.app.manager.order.entity.OrderInfo;
import com.xzsd.app.manager.order.service.MagOrderService;
import com.xzsd.app.manager.personal.controller.MagPersonController;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName  MagOrderController
 * @Description 店长端订单管理控制层
 * @Author hechusheng
 * @Date 2020-04-25
 */
@RestController
@RequestMapping("/managerOrder")
public class MagOrderController {
    private static final Logger logger = LoggerFactory.getLogger(MagPersonController.class);
    @Resource
    private MagOrderService magOrderService;
    /**
     * 查询订单列表
     * @param manageOrder
     * @return
     */
    @RequestMapping("listOrderByPage")
    public AppResponse listOrderByPage(ManageOrder manageOrder){
        try{
            manageOrder.setUserCode(SecurityUtils.getCurrentUserId());
            return magOrderService.listOrderByPage(manageOrder);
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
            return magOrderService.getOrder(orderCode);
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
            return magOrderService.updateOrderStatus(orderInfo);
        }catch (Exception e){
            logger.error("修改订单状态失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
