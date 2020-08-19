package com.xzsd.pc.userClient.dao;

import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.userClient.entity.UserClientInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserClientDao {
    /**
     * 客户列表查询
     * @param userClientInfo
     * @return
     */
    List<UserClientInfo> listUserClientByPage (UserClientInfo userClientInfo);

    /**
     * 查询门店邀请码
     * @param userId
     * @return
     */
    String getInvCode(@Param("userId") String userId);

    /**
     * 查询操作人角色
     * @param userId
     * @return
     */
    UserInfo getUser (@Param("userId") String userId);
}
