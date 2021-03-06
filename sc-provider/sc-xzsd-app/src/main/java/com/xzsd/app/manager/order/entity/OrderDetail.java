package com.xzsd.app.manager.order.entity;

import com.xzsd.app.client.orderform.entity.CmdInfo;

import java.util.List;

/**
 * @ClassName  OrderDetail
 * @Description 店长端订单详情信息实体类
 * @Author hechusheng
 * @Date 2020-04-25
 */
public class OrderDetail {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 订单总价
     */
    private float totalPrice;
    /**
     * 订单状态 0:已下单 1:待取货  2:已取货 3:已完成未评价 4:已评价 5:取消
     */
    private String orderStatus;
    /**
     * 购买总数量
     */
    private int totalCmd;
    /**
     * 顾客编号
     */
    private String userCode;
    /**
     * 顾客名
     */
    private String userName;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 地址(将省市区详细地址拼接而成)
     */
    private String address;
    /**
     * 创建时间
     */
    private String createTime;
    /**
     * 版本号
     */
    private String version;
    /**
     * 门店编号
     */
    private String storeCode;
    /**
     * 商品列表
     */
    private List<CmdInfo> cmdInfoList;

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public List<CmdInfo> getCmdInfoList() {
        return cmdInfoList;
    }

    public void setCmdInfoList(List<CmdInfo> cmdInfoList) {
        this.cmdInfoList = cmdInfoList;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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

    public int getTotalCmd() {
        return totalCmd;
    }

    public void setTotalCmd(int totalCmd) {
        this.totalCmd = totalCmd;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
