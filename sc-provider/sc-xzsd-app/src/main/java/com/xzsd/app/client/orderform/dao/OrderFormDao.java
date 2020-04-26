package com.xzsd.app.client.orderform.dao;

import com.xzsd.app.client.addOrder.entity.OrderDetails;
import com.xzsd.app.client.orderform.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName  OrderFormDao
 * @Description 客户端订单
 * @Author hechusheng
 * @Date 2020-04-24
 */
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

    /**
     * 更新商品库存和销量
     * @param detailList
     * @return
     */
    int updateCmd (@Param("detailsList") List<OrderDetail> detailList);

    /**
     * 更新商品库存和销量
     * @param detailList
     * @return
     */
    int updateCmdSale (@Param("detailsList") List<OrderDetail> detailList);
}
