package com.xzsd.app.client.index.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ShowNumInfo {
    /**
     * 展示数量
     */
    private String showNum;
    /**
     * 作废标记 0为存在，1为作废
     */
    private int isDelete;
    /**
     * 版本号
     */
    private String version;

    public String getShowNum() {
        return showNum;
    }

    public void setShowNum(String showNum) {
        this.showNum = showNum;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
