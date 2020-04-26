package com.xzsd.app.client.orderform.entity;

import java.io.Serializable;

/**
 * @ClassName  AssessInfo
 * @Description 客户端订单评价实体类
 * @Author hechusheng
 * @Date 2020-04-24
 */
public class AssessInfo  implements Serializable {
    /**
     * 客户编号
     */
    private String userCode;
    /**
     * 评价编号
     */
    private String assessCode;
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 商品编号
     */
    private String comCode;
    /**
     * 评价星级
     */
    private int starLevel;
    /**
     * 评价内容
     */
    private String assContent;
    /**
     * 评价时间
     */
    private String assTime;
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

    public AssessInfo() {

    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getAssTime() {
        return assTime;
    }

    public void setAssTime(String assTime) {
        this.assTime = assTime;
    }

    public String getAssessCode() {
        return assessCode;
    }

    public void setAssessCode(String assessCode) {
        this.assessCode = assessCode;
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

    public int getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(int starLevel) {
        this.starLevel = starLevel;
    }

    public String getAssContent() {
        return assContent;
    }

    public void setAssContent(String assContent) {
        this.assContent = assContent;
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
