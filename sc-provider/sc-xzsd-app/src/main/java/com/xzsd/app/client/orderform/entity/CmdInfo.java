package com.xzsd.app.client.orderform.entity;

public class CmdInfo {
    /**
     * 订单详情编号
     */
    private String orderDetailCode;
    /**
     * 商品编号
     */
    private String comCode;
    /**
     * 商品名
     */
    private String comName;
    /**
     * 商品图片
     */
    private String picPath;
    /**
     * 商品介绍
     */
    private String comPresent;
    /**
     * 购买数量
     */
    private int comCount;
    /**
     * 总价
     */
    private float totalPrice;
    /**
     * 售价
     */
    private float comPrice;

    public String getOrderDetailCode() {
        return orderDetailCode;
    }

    public void setOrderDetailCode(String orderDetailCode) {
        this.orderDetailCode = orderDetailCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getComPresent() {
        return comPresent;
    }

    public void setComPresent(String comPresent) {
        this.comPresent = comPresent;
    }

    public int getComCount() {
        return comCount;
    }

    public void setComCount(int comCount) {
        this.comCount = comCount;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public float getComPrice() {
        return comPrice;
    }

    public void setComPrice(float comPrice) {
        this.comPrice = comPrice;
    }
}
