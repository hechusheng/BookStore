package com.xzsd.pc.util;

import java.util.List;

public class CodeList {
    /**
     * 编号列表
     */
    private List<String> codeList;
    /**
     * 热门商品列表
     */
    private List<String> checkHotList;
    /**
     * 轮播图列表
     */
    private List<String> checkCaroList;
    /**
     * 用户列表
     */
    private List<String> checkUserList;
    /**
     * 操作人编号
     */
    private String userId;
    public CodeList() {
    }

    public List<String> getCheckUserList() {
        return checkUserList;
    }

    public void setCheckUserList(List<String> checkUserList) {
        this.checkUserList = checkUserList;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public List<String> getCodeList() {
        return codeList;
    }

    public void setCodeList(List<String> codeList) {
        this.codeList = codeList;
    }

    public List<String> getCheckHotList() {
        return checkHotList;
    }

    public void setCheckHotList(List<String> checkHotList) {
        this.checkHotList = checkHotList;
    }

    public List<String> getCheckCaroList() {
        return checkCaroList;
    }

    public void setCheckCaroList(List<String> checkCaroList) {
        this.checkCaroList = checkCaroList;
    }
}