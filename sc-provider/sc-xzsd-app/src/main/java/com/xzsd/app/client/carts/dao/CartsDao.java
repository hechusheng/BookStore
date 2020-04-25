package com.xzsd.app.client.carts.dao;

import com.xzsd.app.client.carts.entity.CartsInfo;
import com.xzsd.app.client.commodity.entity.CmdInfo;
import com.xzsd.app.client.registered.eneity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import java.util.List;

/**
 * @ClassName CartsDao
 * @Description 购物车信息
 * @Author hechusheng
 * @Date 2020-04-19
 */
@Mapper
public interface CartsDao {
    /**
     * 新增购物车
     * @param cartsInfo
     * @return
     */
    int addCarts (CartsInfo cartsInfo);

    /**
     * 查询购物车列表(分页)
     * @param userId
     * @return
     */
    List<CartsInfo> getCartsByPage (String userId);

    /**
     * 修改购物车数量
     * @param cartsInfo
     * @return
     */
    int updateCarts (CartsInfo cartsInfo);

    /**
     * 查询购物车商品详情
     * @param comCode
     * @param userId
     * @return
     */
    CartsInfo getCarts (@Param("comCode") String comCode, @Param("userId") String userId);

    /**
     * 删除购物车商品
     * @param listCode
     * @param userId
     * @return
     */
    int deleteCarts(@Param("listCode") List<String> listCode, @Param("userId") String userId);
}
