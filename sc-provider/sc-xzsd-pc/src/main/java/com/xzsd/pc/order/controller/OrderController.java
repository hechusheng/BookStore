package com.xzsd.pc.order.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.service.OrderService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private OrderService orderService;

    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
    @RequestMapping("findDetailByCode")
    public AppResponse findDetailByCode(String orderCode){
        try{
            //查询
            AppResponse appResponse = orderService.findDetailByCode(orderCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询订单列表(分页)
     * @param orderInfo
     * @return
     */
    @RequestMapping("listOrderByPage")
    public AppResponse listOrderByPage(OrderInfo orderInfo){
        try{
            //查询
            AppResponse appResponse = orderService.listOrderByPage(orderInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改订单状态
     * @param orderCode
     * @param orderStatus
     * @return
     */
    @PostMapping("updateOrderStatus")
    public AppResponse updateOrderStatus(String orderCode, String orderStatus){
        try{
            //获取修改人编号
            String userId = SecurityUtils.getCurrentUserId();
            return orderService.updateOrderStatus(orderCode,orderStatus,userId);
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
