package com.xzsd.app.client.addOrder.dao;

import com.xzsd.app.client.addOrder.entity.CommodityInfo;
import com.xzsd.app.client.addOrder.entity.OrderDetails;
import com.xzsd.app.client.addOrder.entity.OrderInfo;
import com.xzsd.app.client.addOrder.entity.StoreInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName  OrderDao
 * @Description 客户端订单信息
 * @Author hechusheng
 * @Date 2020-04-21
 */
@Mapper
public interface OrderDao {
    /**
     * 查询用户绑定门店信息
     * @param userCode
     * @return
     */
    StoreInfo getStoreMessage (String userCode);

    /**
     * 查询商品详情
     * @param comCode
     * @return
     */
    CommodityInfo getCmdMessage (String comCode);

    /**
     * 新增订单
     * @return
     */
    int addOrder (OrderInfo orderInfo);

    /**
     * 新增订单详情
     * @param detailsList
     * @return
     */
    int addOrderDetails (@Param("detailsList") List<OrderDetails> detailsList);

    /**
     * 更新商品库存和销量
     * @param detailsList
     * @return
     */
    int updateCmd (@Param("detailsList") List<OrderDetails> detailsList);

    /**
     * 查询商品列表信息
     * @param comCode
     * @return
     */
    List<CommodityInfo> cmdList(@Param("comCode") List<String> comCode);
}
