package com.xzsd.app.client.carts.entity;

/**
 * @ClassName CartsInfo
 * @Description 购物车信息实体类
 * @Author hechusheng
 * @Date 2020-04-19
 */
public class CartsInfo {
    /**
     * 购物车编号
     */
    private String cartCode;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 商品编号
     */
    private String comCode;
    /**
     * 商品名称
     */
    private String ComName;
    /**
     * 商品图片
     */
    private String picPath;
    /**
     * 商品价格
     */
    private float comPrice;
    /**
     * 购物车商品数量
     */
    private int cartAmount;
    /**
     * 总价
     */
    private float totalPrice;
    /**
     * 作废标记 0为存在，1为作废
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

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getComName() {
        return ComName;
    }

    public void setComName(String comName) {
        ComName = comName;
    }

    public float getComPrice() {
        return comPrice;
    }

    public void setComPrice(float comPrice) {
        this.comPrice = comPrice;
    }

    public String getCartCode() {
        return cartCode;
    }

    public void setCartCode(String cartCode) {
        this.cartCode = cartCode;
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

    public int getCartAmount() {
        return cartAmount;
    }

    public void setCartAmount(int cartAmount) {
        this.cartAmount = cartAmount;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
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
