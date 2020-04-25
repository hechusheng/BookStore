package com.xzsd.app.client.addOrder.entity;

import com.xzsd.app.client.orderform.entity.CmdInfo;

import java.util.List;

/**
 * @ClassName  CommodityInfo
 * @Description 客户端订单商品信息实体类
 * @Author hechusheng
 * @Date 2020-04-21
 */
public class CommodityInfo {
    /**
     * 订单编号
     */
    private String orderCode;
    /**
     * 订单详情编号
     */
    private String orderDeatilCode;
    /**
     * 商品编号
     */
    private String comCode;
    /**
     * 商品图片
     */
    private String picPath;
    /**
     * 商品名称
     */
    private String comName;
    /**
     * 购买数量
     */
    private int detailAmount;
    /**
     * 商品介绍
     */
    private String comPresent;
    /**
     * 商品价格
     */
    private float comPrice;
    /**
     * 商品销量
     */
    private int comSale;
    /**
     * 商品库存
     */
    private int comStock;
    /**
     * 评价星级
     */
    private int starLevel;
    /**
     * 送货地址
     */
    private String address;
    /**
     * 版本号
     */
    private String version;

    private List<CmdInfo> cmdInfoList;

    public List<CmdInfo> getCmdInfoList() {
        return cmdInfoList;
    }

    public void setCmdInfoList(List<CmdInfo> cmdInfoList) {
        this.cmdInfoList = cmdInfoList;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getComStock() {
        return comStock;
    }

    public void setComStock(int comStock) {
        this.comStock = comStock;
    }

    public String getOrderDeatilCode() {
        return orderDeatilCode;
    }

    public void setOrderDeatilCode(String orderDeatilCode) {
        this.orderDeatilCode = orderDeatilCode;
    }

    public int getDetailAmount() {
        return detailAmount;
    }

    public void setDetailAmount(int detailAmount) {
        this.detailAmount = detailAmount;
    }

    public String getComPresent() {
        return comPresent;
    }

    public void setComPresent(String comPresent) {
        this.comPresent = comPresent;
    }

    public String getComCode() {
        return comCode;
    }

    public void setComCode(String comCode) {
        this.comCode = comCode;
    }

    public String getPicPath() {
        return picPath;
    }

    public void setPicPath(String picPath) {
        this.picPath = picPath;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public float getComPrice() {
        return comPrice;
    }

    public void setComPrice(float comPrice) {
        this.comPrice = comPrice;
    }

    public int getComSale() {
        return comSale;
    }

    public void setComSale(int comSale) {
        this.comSale = comSale;
    }

    public int getStarLevel() {
        return starLevel;
    }

    public void setStarLevel(int starLevel) {
        this.starLevel = starLevel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
