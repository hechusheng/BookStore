package com.xzsd.app.manager.order.entity;

/**
 * @ClassName  ManagerOrder
 * @Description 客户端订单信息实体类
 * @Author hechusheng
 * @Date 2020-04-25
 */
public class ManageOrder {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 商品编号
     */
    private String comCode;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 购物车编号
     */
    private String cartCode;
    /**
     * 购买数量
     */
    private int detailAmount;
    /**
     * 购买商品数量
     */
    private String comCount;
    /**
     * 门店编号
     */
    private String storeCode;
    /**
     * 订单状态
     */
    private String orderStatus;
    /**
     * 订单总价
     */
    private float totalPrice;
    /**
     * 备注
     */
    private String remark;
    /**
     * 支付时间
     */
    private String payTime;
    /**
     * 支付状态
     */
    private String payStatus;
    /**
     * 付款时间起
     */
    private String payTimeStart;
    /**
     * 付款时间止
     */
    private String payTimeEnd;
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

    public ManageOrder() {

    }

    public ManageOrder(String orderCode, String orderStatus, String updateUser) {
        this.orderCode = orderCode;
        this.orderStatus = orderStatus;
        this.updateUser = updateUser;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getCartCode() {
        return cartCode;
    }

    public void setCartCode(String cartCode) {
        this.cartCode = cartCode;
    }

    public int getDetailAmount() {
        return detailAmount;
    }

    public void setDetailAmount(int detailAmount) {
        this.detailAmount = detailAmount;
    }

    public String getComCount() {
        return comCount;
    }

    public void setComCount(String comCount) {
        this.comCount = comCount;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getPayStatus() {
        return payStatus;
    }

    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus;
    }

    public String getPayTimeStart() {
        return payTimeStart;
    }

    public void setPayTimeStart(String payTimeStart) {
        this.payTimeStart = payTimeStart;
    }

    public String getPayTimeEnd() {
        return payTimeEnd;
    }

    public void setPayTimeEnd(String payTimeEnd) {
        this.payTimeEnd = payTimeEnd;
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
