package com.xzsd.app.client.addOrder.service;

import com.xzsd.app.client.carts.dao.CartsDao;
import com.xzsd.app.client.addOrder.dao.OrderDao;
import com.xzsd.app.client.addOrder.entity.CommodityInfo;
import com.xzsd.app.client.addOrder.entity.OrderDetails;
import com.xzsd.app.client.addOrder.entity.OrderInfo;
import com.xzsd.app.client.addOrder.entity.StoreInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName  OrderService
 * @Description 客户端订单信息实现层
 * @Author hechusheng
 * @Date 2020-04-21
 */
@Service
public class OrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private CartsDao cartsDao;

    /**
     * 新增订单
     * @param orderInfo
     * @return
     */
    public AppResponse addOrder (OrderInfo orderInfo) {
        //判断用户是否绑定了门店邀请码
        StoreInfo store = orderDao.getStoreMessage(orderInfo.getUserCode());
        if (null == store) {
            return AppResponse.bizError("门店邀请码未绑定");
        }
        //输入商品编号列表
        List<String> commodityList = Arrays.asList(orderInfo.getComCode().split(","));
        //输入商品数量列表
        List<String> detailAmountList = Arrays.asList(orderInfo.getComCount().split(","));
        //生成订单编号,设置订单信息
        orderInfo.setOrderCode(StringUtil.getCommonCode(2));
        orderInfo.setIsDelete(0);
        orderInfo.setTotalPrice(0);
        //购买商品，订单状态为0（已下单）
        orderInfo.setOrderStatus("0");
        //默认支付成功
        orderInfo.setPayStatus("0");
        //判断是否有些备注
        if (orderInfo.getRemark() == null || "".equals(orderInfo.getRemark())){
            orderInfo.setRemark("无备注！");
        }
        orderInfo.setStoreCode(orderDao.getStoreMessage(orderInfo.getUserCode()).getStoreCode());
        //新建订单详情列表
        List<OrderDetails> detailsList = new ArrayList<>();
        //获取商品信息列表
        List<CommodityInfo> commodityInfoList = orderDao.cmdList(commodityList);
        //新建一个StringBuilder对象
        StringBuilder stock  = new StringBuilder();
        int totalCmd = 0;
        for (int i = 0; i < commodityList.size(); i++){
            //生成订单详情编号
            String orderDetailCode = StringUtil.getCommonCode(2);
            //获取商品单价
            float price = 0;
            for (int j = 0; j < commodityList.size(); j++) {
                if (commodityList.get(i).equals(commodityInfoList.get(j).getComCode())) {
                    //设置商品的单价
                    price = commodityInfoList.get(i).getComPrice();
                    //判断该商品的库存是否充足，若不足，将名称其存到stock中
                    if (Integer.parseInt(detailAmountList.get(i))> commodityInfoList.get(j).getComStock()){
                        stock.append(commodityInfoList.get(j).getComName()).append(",");
                    }
                    break;
                }
            }
            if(0 != price){
                //创建订单详情对象（详情编号，商品编号，商品数量，商品价格）
                OrderDetails orderDetails = new OrderDetails(orderDetailCode,commodityList.get(i),Integer.parseInt(detailAmountList.get(i)),price);
                //统计购买商品的总数
                totalCmd = totalCmd + Integer.parseInt(detailAmountList.get(i));
                //设置订单详情信息
                orderDetails.setOrderCode(orderInfo.getOrderCode());
                orderDetails.setIsDelete(0);
                orderDetails.setCreateUser(orderInfo.getCreateUser());
                orderDetails.setUpdateUser(orderInfo.getCreateUser());
                orderDetails.setComCount(Integer.parseInt(detailAmountList.get(i)));
                orderInfo.setTotalPrice(orderInfo.getTotalPrice() + price * Integer.parseInt(detailAmountList.get(i)));
                //添加到list
                detailsList.add(orderDetails);
            }
        }
        orderInfo.setTotalCmd(totalCmd);
        //修改商品库存
        int countCmd = orderDao.updateCmd(detailsList);
        if (0 == countCmd) {
            return AppResponse.bizError(stock +"库存不足！");
        }
        //新增订单
        int count = orderDao.addOrder(orderInfo);
        if (0 == count) {
            return AppResponse.bizError("新增订单失败！");
        }
        //新建订单详情
        int countOrderDet = orderDao.addOrderDetails(detailsList);
        if (0 == countOrderDet) {
            return AppResponse.success("新增详情失败！");
        }
        //如果是在购物车里购买 ， 则需要将商品移除购物车
        if (orderInfo.getCartCode() != null && !"".equals(orderInfo.getCartCode())){
            //新建购物车编号列表
            List<String> cartCodeList = Arrays.asList(orderInfo.getCartCode().split(","));
            int countCart = cartsDao.deleteCarts(cartCodeList,orderInfo.getUserCode());
            if (0 == countCart){
                return AppResponse.bizError("删除购物车失败！");
            }
        }
        return AppResponse.success("新增订单成功！");
    }
}
