package com.xzsd.pc.order.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class OrderDetails {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 商品编号
     */
    private String comCode;
    /**
     * 购买数量
     */
    private int detailAmount;
    /**
     * 订单详情编号
     */
    private String orderDetailsCode;
    /**
     * 商品名
     */
    private String comName;
    /**
     * 总价
     */
    private float totalPrice;
    /**
     * 售价
     */
    private float comPrice;
    /**
     * 成本价
     */
    private float comCost;
    /**
     * 删除标记
     */
    private int isDelete;
    /**
     * 创建者
     */
    private String createUser;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 更新者
     */
    private String updateUser;
    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 版本号
     */
    private String version;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public int getDetailAmount() {
        return detailAmount;
    }

    public void setDetailAmount(int detailAmount) {
        this.detailAmount = detailAmount;
    }

    public String getOrderDetailsCode() {
        return orderDetailsCode;
    }

    public void setOrderDetailsCode(String orderDetailsCode) {
        this.orderDetailsCode = orderDetailsCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
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

    public float getComCost() {
        return comCost;
    }

    public void setComCost(float comCost) {
        this.comCost = comCost;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
