package com.xzsd.app.client.addOrder.entity;

import java.util.List;

/**
 * @ClassName  OrderDetailsInfo
 * @Description 客户端订单详情信息实体类
 * @Author hechusheng
 * @Date 2020-04-21
 */
public class OrderDetails {
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
    private int comCount;
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
     * 订单状态
     */
    private String orderStatus;
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
    /**
     * 商品列表
     */
    private List<CommodityInfo> cmdList;
    /**
     * 省市区加详细地址
     */
    private String address;

    public OrderDetails (){
    }

    public OrderDetails(String orderDetailsCode, String comCode, int comCount, float comPrice) {
        this.orderDetailsCode = orderDetailsCode;
        this.comCode = comCode;
        this.comCount = comCount;
        this.comPrice = comPrice;
    }

    public List<CommodityInfo> getCmdList() {
        return cmdList;
    }

    public void setCmdList(List<CommodityInfo> cmdList) {
        this.cmdList = cmdList;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
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

    public int getComCount() {
        return comCount;
    }

    public void setComCount(int comCount) {
        this.comCount = comCount;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
