package com.xzsd.app.manager.personal.entity;

/**
 * @ClassName DriverInfo
 * @Description 店长端司机信息实体类
 * @Author hechusheng
 * @Date 2020-04-21
 */
public class DriverInfo {
    /**
     * 用户名称
     */
    private String userName;
    /**
     * 司机电话
     */
    private String phone;
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 用户角色
     */
    private String role;

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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
