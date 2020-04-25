package com.xzsd.pc.topBar.entity;

/**
 * 顶部栏实体类
 */
public class TopBarInfo {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 用户头像
     */
    private String photo;
    /**
     * 用户角色
     */
    private String role;
    /**
     * 操作人编号
     */
    private String userId;

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

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
