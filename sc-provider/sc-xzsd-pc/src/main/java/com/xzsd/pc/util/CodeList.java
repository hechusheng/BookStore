package com.xzsd.pc.util;

import java.util.List;

public class CodeList {
    private List<String> codeList;
    private List<String> checkHotList;
    private List<String> checkCaroList;
    private String userId;
    public CodeList() {
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