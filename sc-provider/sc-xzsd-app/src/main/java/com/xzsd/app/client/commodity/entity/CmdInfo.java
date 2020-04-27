package com.xzsd.app.client.commodity.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @ClassName CmdInfo
 * @Description 商品信息实体类
 * @Author hechusheng
 * @Date 2020-04-17
 */
public class CmdInfo {
    /**
     * 商品编号
     */
    private String comCode;
    /**
     * 商品名称
     */
    private String comName;
    /**
     * 商家名称
     */
    private String bussName;
    /**
     * 书号
     */
    private String comNum;
    /**
     * 商品库存
     */
    private int comStock;
    /**
     * 成本价
     */
    private float comCost;
    /**
     * 商品售价
     */
    private float comPrice;
    /**
     * 浏览量
     */
    private int pageViews;
    /**
     * 定价
     */
    private float fixedPrice;
    /**
     * 商品销量
     */
    private int comSales;
    /**
     * 一级分类编号
     */
    private String firstSortCode;
    /**
     * 一级分类名称
     */
    private String firstSortName;
    /**
     * 二级分类编号
     */
    private String secondSortCode;
    /**
     * 二级分类名称
     */
    private String secondSortName;
    /**
     *图片路径
     */
    private String picPath;
    /**
     * 商品状态(0在售 1下架 2未发布)
     */
    private String comStatus;
    /**
     * 商品介绍
     */
    private String comPresent;
    /**
     * 上架时间
     */
    private Date shelvesTime;
    /**
     * 广告词
     */
    private String advertisement;
    /**
     * 作者
     */
    private String author;
    /**
     * 出版社
     */
    private String press;
    /**
     * 商品星级
     */
    private float starLevel;
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


    public float getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(float starLevel) {
        this.starLevel = starLevel;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getBussName() {
        return bussName;
    }

    public void setBussName(String bussName) {
        this.bussName = bussName;
    }

    public String getComNum() {
        return comNum;
    }

    public void setComNum(String comNum) {
        this.comNum = comNum;
    }

    public int getComStock() {
        return comStock;
    }

    public void setComStock(int comStock) {
        this.comStock = comStock;
    }

    public float getComCost() {
        return comCost;
    }

    public void setComCost(float comCost) {
        this.comCost = comCost;
    }

    public float getComPrice() {
        return comPrice;
    }

    public void setComPrice(float comPrice) {
        this.comPrice = comPrice;
    }

    public int getPageViews() {
        return pageViews;
    }

    public void setPageViews(int pageViews) {
        this.pageViews = pageViews;
    }

    public float getFixedPrice() {
        return fixedPrice;
    }

    public void setFixedPrice(float fixedPrice) {
        this.fixedPrice = fixedPrice;
    }

    public int getComSales() {
        return comSales;
    }

    public void setComSales(int comSales) {
        this.comSales = comSales;
    }

    public String getFirstSortCode() {
        return firstSortCode;
    }

    public void setFirstSortCode(String firstSortCode) {
        this.firstSortCode = firstSortCode;
    }

    public String getFirstSortName() {
        return firstSortName;
    }

    public void setFirstSortName(String firstSortName) {
        this.firstSortName = firstSortName;
    }

    public String getSecondSortCode() {
        return secondSortCode;
    }

    public void setSecondSortCode(String secondSortCode) {
        this.secondSortCode = secondSortCode;
    }

    public String getSecondSortName() {
        return secondSortName;
    }

    public void setSecondSortName(String secondSortName) {
        this.secondSortName = secondSortName;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getComStatus() {
        return comStatus;
    }

    public void setComStatus(String comStatus) {
        this.comStatus = comStatus;
    }

    public String getComPresent() {
        return comPresent;
    }

    public void setComPresent(String comPresent) {
        this.comPresent = comPresent;
    }

    public Date getShelvesTime() {
        return shelvesTime;
    }

    public void setShelvesTime(Date shelvesTime) {
        this.shelvesTime = shelvesTime;
    }

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
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
