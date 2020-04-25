package com.xzsd.pc.topBar.dao;

import com.xzsd.pc.topBar.entity.TopBarInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopBarDao {
    /**
     * 查询操作人角色
     * @param userId
     * @return
     */
    TopBarInfo getUser (String userId);

    /**
     * 获取顶部栏用户信息
     * @return
     */
    TopBarInfo getTopBar (String userCode);
}
