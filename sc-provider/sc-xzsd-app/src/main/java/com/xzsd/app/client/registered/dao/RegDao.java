package com.xzsd.app.client.registered.dao;

import com.xzsd.app.client.registered.eneity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName RegDao
 * @Description 用户注册管理
 * @Author hechusheng
 * @Date 2020-04-17
 */
@Mapper
public interface RegDao {
    /**
     * 新增用户(注册)
     * @param userInfo
     * @return
     */
    int addUser (UserInfo userInfo);
    int addUserClient (UserInfo userInfo);

    /**
     * 统计用户账号
     * @param userInfo
     * @return
     */
    int countUserAccount (UserInfo userInfo);

    /**
     * 统计门店邀请码
     * @param userInfo
     * @return
     */
    int countInviteCode (UserInfo userInfo);

    /**
     * 统计用户身份证
     * @param userInfo
     * @return
     */
    int countIdCard (UserInfo userInfo);
}
