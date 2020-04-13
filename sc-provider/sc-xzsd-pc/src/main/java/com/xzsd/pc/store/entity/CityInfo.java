package com.xzsd.pc.store.entity;

public class CityInfo {
    /**
     * 市编号
     */
    private String cityCode;
    /**
     * 市名称
     */
    private String city;
    /**
     * 父级编号
     */
    private String provinceCode;

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvinceCode() {
        return provinceCode;
    }

    public void setProvinceCode(String provinceCode) {
        this.provinceCode = provinceCode;
    }
}
