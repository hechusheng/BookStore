package com.xzsd.app.client.personal.service;


import com.xzsd.app.client.personal.dao.PersonalDao;
import com.xzsd.app.client.personal.entity.PasswordInfo;
import com.xzsd.app.client.personal.entity.PersonalInfo;
import com.xzsd.app.client.registered.eneity.UserInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.PasswordUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName PersonalService
 * @Description 用户个人信息实现层
 * @Author hechusheng
 * @Date 2020-04-20
 */
@Service
public class PersonalService {
    @Resource
    private PersonalDao personalDao;

    /**
     * 查询用户个人信息
     * @param personalInfo
     * @return
     */
    public AppResponse getUserMessage (PersonalInfo personalInfo) {
        //获取用户角色、编号
        UserInfo userInfo = personalDao.getUser(personalInfo.getUserCode());
        personalInfo.setRole(userInfo.getRole());
        //获取登录用户个人信息
        PersonalInfo personal = personalDao.getUserMessage(personalInfo);
        return AppResponse.success("查询个人信息成功",personal);
    }

    /**
     * 修改用户密码
     * @param passwordInfo
     * @return
     */
    public AppResponse updateUserPassword (PasswordInfo passwordInfo) {
        //判断原密码
        if(passwordInfo.getUserPassword() != null || passwordInfo.getUserPassword() != "") {
            //获取原密码
            String oldPassword = passwordInfo.getUserPassword();
            //获取用户信息(加密的密码)
            UserInfo user = personalDao.getUser(passwordInfo.getUserCode());
            if(user == null) {
                return AppResponse.bizError("用户已删除或者用户不存在！");
            }
            if(!PasswordUtils.Password(oldPassword,user.getUserPassword())) {
                return AppResponse.bizError("原密码不正确！");
            }
        }
        //判断检验密码跟新密码是否一致
        if(!passwordInfo.getCheckPassword().equals(passwordInfo.getNewUserPassword())) {
            return AppResponse.bizError("两次输入的新密码不相同！");
        }
        //将新密码加密
        passwordInfo.setNewUserPassword(PasswordUtils.generatePassword(passwordInfo.getNewUserPassword()));
        //修改密码
        int count = personalDao.updateUserPassword(passwordInfo);
        if (count == 0) {
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("修改用户密码成功！");
    }

    /**
     * 修改客户门店邀请码
     * @param personalInfo
     * @return
     */
    public AppResponse updateInviteCode (PersonalInfo personalInfo) {
        int countInviteCode = personalDao.countInviteCode(personalInfo.getInviteCode());
        if (countInviteCode == 0 ) {
            return AppResponse.bizError("门店邀请码不存在！");
        }
        //修改邀请码
        int count = personalDao.updateInviteCode(personalInfo);
        if (count == 0) {
            return AppResponse.bizError("修改时门店邀请码失败");
        }
        return AppResponse.success("修改门店邀请码成功！");
    }
}
