package com.xzsd.pc.order.service;

import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderDetails;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;
    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
    public AppResponse findDetailByCode(String orderCode){
        List<OrderDetails> orderDetailList = orderDao.findDetailByCode(orderCode);
        return AppResponse.success("查询订单详情成功！",orderDetailList);
    }

    /**
     * 查询订单列表(分页)
     * @param orderInfo
     * @return
     */
    public AppResponse listOrderByPage (OrderInfo orderInfo) {
        //获取操作人的角色
        UserInfo userInfo = orderDao.getUser(orderInfo.getUserId());
        if(userInfo != null && userInfo.getRole() != ""){
            orderInfo.setRole(userInfo.getRole());
        }
        List<OrderInfo> orderInfoList = orderDao.listOrderByPage(orderInfo);
        return AppResponse.success("查询订单列表成功！", getPageInfo(orderInfoList));
    }

    /**
     * 修改订单状态
     * @param orderCode
     * @param orderStatus
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderStatus (String orderCode, String orderStatus, String userId) {
        List<String> listCode = Arrays.asList(orderCode.split(","));
        AppResponse appResponse = AppResponse.success("订单状态修改成功！");
        //修改商品
        int count = orderDao.updateOrderStatus(listCode,orderStatus,userId);
        if(0 == count){
            appResponse = AppResponse.bizError("订单状态修改失败，请重试！");
        }
        return appResponse;
    }
}
