package com.xzsd.app.client.index.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ClassName CarouselInfo
 * @Description 首页轮播图实体类
 * @Author hechusheng
 * @Date 2020-04-17
 */
public class CarouselInfo {
    /**
     * 轮播图编号
     */
    private String caroCode;

    /**
     * 轮播图序号
     */
    private String caroNum;

    /**
     * 图片路径
     */
    private String path;

    /**
     * 轮播图状态态(0启用 1禁用)
     */
    private String caroStatus;

    /**
     *有效时间起
     */
    private String startTime;

    /**
     * 有效时间止
     */
    private String endTime;

    /**
     * 商品编号
     */
    private String comCode;
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

    public String getCaroCode() {
        return caroCode;
    }

    public void setCaroCode(String caroCode) {
        this.caroCode = caroCode;
    }

    public String getCaroNum() {
        return caroNum;
    }

    public void setCaroNum(String caroNum) {
        this.caroNum = caroNum;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCaroStatus() {
        return caroStatus;
    }

    public void setCaroStatus(String caroStatus) {
        this.caroStatus = caroStatus;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
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
