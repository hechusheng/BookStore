package com.xzsd.app.client.addOrder.entity;

import java.util.List;

public class ODInfo {
    /**
     *
     */
    private String orderCode;
    /**
     * 购买商品总数量
     */
    private int deatil_amount;
    /**
     * 订单总价
     */
    private float totalPrice;
    /**
     * 订单状态
     */
    private String orderStatus;
    /**
     * 商品列表
     */
    private List<CommodityInfo> commodityInfoList;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getDeatil_amount() {
        return deatil_amount;
    }

    public void setDeatil_amount(int deatil_amount) {
        this.deatil_amount = deatil_amount;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public List<CommodityInfo> getCommodityInfoList() {
        return commodityInfoList;
    }

    public void setCommodityInfoList(List<CommodityInfo> commodityInfoList) {
        this.commodityInfoList = commodityInfoList;
    }
}
