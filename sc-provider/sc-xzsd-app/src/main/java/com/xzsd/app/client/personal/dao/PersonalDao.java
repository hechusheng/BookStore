package com.xzsd.app.client.personal.dao;

import com.xzsd.app.client.personal.entity.PasswordInfo;
import com.xzsd.app.client.personal.entity.PersonalInfo;
import com.xzsd.app.client.registered.eneity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

/**
 * @ClassName PersionalDao
 * @Description 用户个人信息
 * @Author hechusheng
 * @Date 2020-04-20
 */
@Mapper
public interface PersonalDao {
    /**
     * 获取用户角色
     * @param userCode
     * @return
     */
    UserInfo getUser (String userCode);

    /**
     * 获取用户个人信息
     * @param personalInfo
     * @return
     */
    PersonalInfo getUserMessage (PersonalInfo personalInfo);

    /**
     * 修改用户密码
     * @param passwordInfo
     * @return
     */
    int updateUserPassword (PasswordInfo passwordInfo);

    /**
     * 修改门店邀请码
     * @param personalInfo
     * @return
     */
    int updateInviteCode (PersonalInfo personalInfo);

    int countInviteCode (String inviteCode);
}
