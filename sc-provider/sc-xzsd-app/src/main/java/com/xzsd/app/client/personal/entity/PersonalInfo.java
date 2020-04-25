package com.xzsd.app.client.personal.entity;

/**
 * @ClassName CartsService
 * @Description 用户个人信息实现层
 * @Author hechusheng
 * @Date 2020-04-20
 */
public class PersonalInfo {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 用户账号
     */
    private String userAccount;
    /**
     * 用户姓名
     */
    private String userName;
    /**
     * 用户头像路径
     */
    private String photo;
    /**
     * 用户角色
     */
    private String role;
    /**
     * 门店编号
     */
    private String storeCode;
    /**
     * 门店名称
     */
    private String storeName;
    /**
     * 门店邀请码
     */
    private String inviteCode;
    /**
     * 地址
     */
    private String address;
    /**
     * 手机号
     */
    private String phone;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
