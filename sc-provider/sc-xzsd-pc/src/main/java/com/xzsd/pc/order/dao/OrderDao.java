package com.xzsd.pc.order.dao;

import com.xzsd.pc.order.entity.OrderDetails;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderDao {
    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
    List<OrderDetails> findDetailByCode(String orderCode);

    /**
     * 查询订单列表(分页)
     * @param orderInfo
     * @return
     */
    List<OrderInfo> listOrderByPage (OrderInfo orderInfo);

    /**
     * 获取操作人的编号
     * @param userCode
     * @return
     */
    UserInfo getUser(String userCode);

    /**
     * 修改订单状态
     * @param listCode
     * @param orderStatus
     * @param userId
     * @return
     */
    int updateOrderStatus(@Param("listCode") List<String> listCode, @Param("orderStatus") String orderStatus,@Param("userId") String userId);
}
