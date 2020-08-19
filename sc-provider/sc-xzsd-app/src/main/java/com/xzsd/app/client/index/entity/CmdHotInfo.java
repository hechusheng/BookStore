package com.xzsd.app.client.index.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ClassName CmdHotInfo
 * @Description 热门商品实体类
 * @Author hechusheng
 * @Date 2020-04-17
 */
public class CmdHotInfo {
    /**
     * 热门位商品编号
     */
    private String hotCode;
    /**
     * 商品编号
     */
    private String comCode;
    /**
     * 热门位商品序号
     */
    private String hotNum;
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
    /**
     * 商品名称
     */
    private String comName;
    /**
     * 商品介绍
     */
    private String comPresent;
    /**
     * 商品图片
     */
    private String picPath;
    /**
     *商品价格
     */
    private float comPrice;

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public float getComPrice() {
        return comPrice;
    }

    public void setComPrice(float comPrice) {
        this.comPrice = comPrice;
    }

    public String getHotCode() {
        return hotCode;
    }

    public void setHotCode(String hotCode) {
        this.hotCode = hotCode;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getHotNum() {
        return hotNum;
    }

    public void setHotNum(String hotNum) {
        this.hotNum = hotNum;
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

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComPresent() {
        return comPresent;
    }

    public void setComPresent(String comPresent) {
        this.comPresent = comPresent;
    }
}
