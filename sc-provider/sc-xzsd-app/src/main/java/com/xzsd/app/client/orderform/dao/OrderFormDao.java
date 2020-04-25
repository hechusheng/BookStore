package com.xzsd.app.client.orderform.dao;

import com.xzsd.app.client.orderform.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderFormDao {
    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     */
    List<OrderDetail> listOrderByPage(OrderInfo orderInfo);
    List<CmdInfo> orderCmd (OrderInfo orderInfo);

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

    /**
     * 新增订单评价
     * @param orderAssess
     * @return
     */
    int addCommodityAssess (OrderAssess orderAssess);

    /**
     * 查询订单状态
     * @param orderCode
     * @return
     */
    OrderInfo getOrderStatus (String orderCode);

    /**
     * 更新商品星级
     * @param assessInfoList
     * @return
     */
    int updateStarLevel (@Param("assessInfoList") List<AssessInfo> assessInfoList);
}
