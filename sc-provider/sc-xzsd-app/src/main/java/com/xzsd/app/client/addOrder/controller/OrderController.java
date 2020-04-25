package com.xzsd.app.client.addOrder.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.client.addOrder.entity.OrderInfo;
import com.xzsd.app.client.addOrder.service.OrderService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName  OrderController
 * @Description 客户端订单信息控制层
 * @Author hechusheng
 * @Date 2020-04-22
 */
@RestController
@RequestMapping("/buy")
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    @Resource
    private OrderService orderService;

    /**
     * 新建订单
     * @param orderInfo
     * @return
     */
    @PostMapping("addOrder")
    public AppResponse addOrder (OrderInfo orderInfo) {
        try {
            String userCode = SecurityUtils.getCurrentUserId();
            orderInfo.setCreateUser(userCode);
            orderInfo.setUserCode(userCode);
            orderInfo.setUpdateUser(userCode);
            return orderService.addOrder(orderInfo);
        }catch (Exception e){
            logger.error("购买失败");
            System.out.println(e.toString());
            throw e;
        }
    }

}
