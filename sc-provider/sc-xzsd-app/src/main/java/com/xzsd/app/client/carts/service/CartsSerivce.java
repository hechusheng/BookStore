package com.xzsd.app.client.carts.service;

import com.xzsd.app.client.carts.dao.CartsDao;
import com.xzsd.app.client.carts.entity.CartsInfo;
import com.xzsd.app.client.commodity.dao.CmdDao;
import com.xzsd.app.client.commodity.entity.CmdInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @ClassName CartsService
 * @Description 购物车信息实现层
 * @Author hechusheng
 * @Date 2020-04-19
 */
@Service
public class CartsSerivce {
    @Resource
    private CartsDao cartsDao;
    @Resource
    private CmdDao cmdDao;

    /**
     * 新增购物车
     * @param cartsInfo
     * @return
     */
    public AppResponse addCatrs (CartsInfo cartsInfo) {
        //查看改商品是否存在购物车中，若存在，则数量相加
        CartsInfo countComCode = cartsDao.getCarts(cartsInfo.getComCode(),cartsInfo.getUserCode());
        if (countComCode != null){
            CartsInfo cartsCmd = new CartsInfo();
            cartsCmd.setCartCode(countComCode.getCartCode());
            System.out.println("购物车编号" + cartsCmd.getCartCode());
            cartsCmd.setComCode(cartsInfo.getComCode());
            System.out.println("商品编号" + cartsCmd.getComCode());
            cartsCmd.setCartAmount(countComCode.getCartAmount() + cartsInfo.getCartAmount());
            System.out.println("购买数量 = " + cartsCmd.getCartAmount());
            cartsCmd.setUserCode(cartsInfo.getUserCode());
            System.out.println("用户编号" + cartsCmd.getUserCode());
            cartsCmd.setTotalPrice(countComCode.getComPrice() * cartsCmd.getCartAmount());
            int count = cartsDao.updateCarts(cartsCmd);
            if (0 == count) {
                return AppResponse.bizError("添加购物车失败！");
            }
            return AppResponse.success("成功添加至购物车！");
        }
        //生成购物车编号
        cartsInfo.setCartCode(StringUtil.getCommonCode(2));
        //获取购物车商品详情
        CmdInfo cmdInfo = cmdDao.getCommodity(cartsInfo.getComCode());
        if (cmdInfo == null) {
            return AppResponse.bizError("获取商品详情失败");
        }
        cartsInfo.setIsDelete(0);
        cartsInfo.setTotalPrice(cmdInfo.getComPrice() * cartsInfo.getCartAmount());
        //新增购物车
        int count = cartsDao.addCarts(cartsInfo);
        if (0 == count) {
            return AppResponse.bizError("添加购物车失败");
        }
        return AppResponse.success("成功添加至购物车");
    }

    /**
     * 查询购物车列表(分页)
     * @param userId
     * @return
     */
    public AppResponse getCartsByPage (String userId) {
        //查询
        List<CartsInfo> cartsInfoList = cartsDao.getCartsByPage(userId);
        return AppResponse.success("查询购物车列表成功！",getPageInfo(cartsInfoList));
    }

    /**
     * 修改购物车商品数量
     * @param cartsInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateCarts (CartsInfo cartsInfo) {
        //获取购物车商品详情
        CmdInfo cmdInfo = cmdDao.getCommodity(cartsInfo.getComCode());
        if (cmdInfo == null) {
            return AppResponse.bizError("获取商品详情失败");
        }
        cartsInfo.setTotalPrice(cmdInfo.getComPrice() * cartsInfo.getCartAmount());
        int count = cartsDao.updateCarts(cartsInfo);
        if (0 == count) {
            return AppResponse.bizError("修改失败！");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * 删除购物车商品
     * @param cartCode
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String cartCode, String userId) {
        List<String> listCode = Arrays.asList(cartCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除购物车商品
        int count = cartsDao.deleteCarts(listCode,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }
}
