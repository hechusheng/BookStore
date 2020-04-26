package com.xzsd.app.manager.order.dao;

import com.xzsd.app.manager.order.entity.ManageOrder;
import com.xzsd.app.manager.order.entity.OrderDetail;
import com.xzsd.app.manager.order.entity.OrderInfo;
import com.xzsd.app.manager.order.entity.StoreInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName  MagOrderDao
 * @Description 店长端订单管理
 * @Author hechusheng
 * @Date 2020-04-25
 */
@Mapper
public interface MagOrderDao {
    /**
     * 查询订单列表
     * @param
     * @return
     */
    List<OrderDetail> listOrderByPage(ManageOrder manageOrder);

    /**
     * 查询用户绑定门店信息
     * @param userCode
     * @return
     */
    StoreInfo getStoreMessage (String userCode);

    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
    OrderDetail getOrder(@Param("orderCode") String orderCode);

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    int updateOrderStatus(OrderInfo orderInfo);
}
