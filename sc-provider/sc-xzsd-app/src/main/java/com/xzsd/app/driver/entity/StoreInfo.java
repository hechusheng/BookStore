package com.xzsd.app.driver.entity;

/**
 * @ClassName StoreInfo
 * @Description 司机端门店信息实体类
 * @Author hechusheng
 * @Date 2020-04-21
 */
public class StoreInfo {
    /**
     * 店长编号
     */
    private String userCode;
    /**
     * 店长姓名
     */
    private String userName;
    /**
     * 门店编号
     */
    private String storeCode;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     *门店地址
     */
    private String storeAddress;
    /**
     * 店长手机
     */
    private String phone;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
