package com.xzsd.app.client.personal.entity;

/**
 * @ClassName PasswordInfo
 * @Description 用户密码实体类
 * @Author hechusheng
 * @Date 2020-04-21
 */
public class PasswordInfo {
    /**
     * 用户编号
     */
    private String userCode;
    /**
     * 用户原密码
     */
    private String userPassword;
    /**
     * 用户新密码
     */
    private String newUserPassword;
    /**
     * 检验密码
     */
    private String checkPassword;
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

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getNewUserPassword() {
        return newUserPassword;
    }

    public void setNewUserPassword(String newUserPassword) {
        this.newUserPassword = newUserPassword;
    }

    public String getCheckPassword() {
        return checkPassword;
    }

    public void setCheckPassword(String checkPassword) {
        this.checkPassword = checkPassword;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
