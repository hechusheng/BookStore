package com.xzsd.pc.store.entity;

public class AreaInfo {
    /**
     * 区/县编号
     */
    private String areaCode;
    /**
     * 区/县名称
     */
    private String area;
    /**
     * 父级编号
     */
    private String cityCode;

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }
}
