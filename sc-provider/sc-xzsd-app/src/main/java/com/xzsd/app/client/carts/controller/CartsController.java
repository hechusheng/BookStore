package com.xzsd.app.client.carts.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.client.carts.entity.CartsInfo;
import com.xzsd.app.client.carts.service.CartsSerivce;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/clientCarts")
public class CartsController {
    private static final Logger logger = LoggerFactory.getLogger(CartsController.class);
    @Resource
    private CartsSerivce cartsSerivce;

    /**
     * 新增购物车
     * @param cartsInfo
     * @return
     */
    @PostMapping("addCarts")
    public AppResponse addCarts (CartsInfo cartsInfo) {
        try {
            //获取登录用户编号
            String userId = SecurityUtils.getCurrentUserId();
            cartsInfo.setCreateUser(userId);
            cartsInfo.setUpdateUser(userId);
            cartsInfo.setUserCode(userId);
            return cartsSerivce.addCatrs(cartsInfo);
        } catch (Exception e) {
            logger.error("添加购物车失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询购物车列表(分页)
     * @return
     */
    @RequestMapping("getCartsByPage")
    public AppResponse getCartsByPage () {
        try {
            //获取登录用户编号
            String userId = SecurityUtils.getCurrentUserId();
            System.out.println("登录人的用户编号：" + userId);
            return cartsSerivce.getCartsByPage(userId);
        } catch (Exception e) {
            logger.error("添加购物车失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改购物车商品数量
     * @param cartsInfo
     * @return
     */
    @PostMapping("updateCarts")
    public AppResponse updateCarts (CartsInfo cartsInfo) {
        try {
            //获取登录用户编号
            String userId = SecurityUtils.getCurrentUserId();
            cartsInfo.setUpdateUser(userId);
            return cartsSerivce.updateCarts(cartsInfo);
        } catch (Exception e) {
            logger.error("修改购物车商品数量失败",e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除购物车商品
     * @param cartCode
     * @return
     */
    @PostMapping("deleteCarts")
    public AppResponse deleteCarts(String cartCode) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return cartsSerivce.deleteUser(cartCode,userId);
        } catch (Exception e) {
            logger.error("购物车商品删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
