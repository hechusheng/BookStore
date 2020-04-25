package com.xzsd.app.client.personal.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.client.personal.entity.PasswordInfo;
import com.xzsd.app.client.personal.entity.PersonalInfo;
import com.xzsd.app.client.personal.service.PersonalService;
import com.xzsd.app.client.registered.eneity.UserInfo;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName  PersionalController
 * @Description 用户个人信息控制层
 * @Author hechusheng
 * @Date 2020-04-20
 */
@RestController
@RequestMapping("/clientPersonal")
public class PersonalController {
    private static final Logger logger = LoggerFactory.getLogger(PersonalController.class);
    @Resource
    private PersonalService personalService;

    /**
     * 获取登录用户信息
     * @return
     */
    @RequestMapping("getUserMessage")
    public AppResponse getUserMessage (PersonalInfo personalInfo) {
        try {
            //获取当前登录用户编号
            personalInfo.setUserCode(SecurityUtils.getCurrentUserId());
            return personalService.getUserMessage(personalInfo);
        } catch (Exception e) {
            logger.error("查询用户信息失败！");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改用户密码
     * @param passwordInfo
     * @return
     */
    @PostMapping("updateUserPassword")
    public AppResponse updateUserPassword (PasswordInfo passwordInfo) {
        try {
            //获取当前登录用户编号
            passwordInfo.setUserCode(SecurityUtils.getCurrentUserId());
            return personalService.updateUserPassword(passwordInfo);
        } catch (Exception e) {
            logger.error("修改用户密码失败！");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改客户门店邀请码
     * @return
     */
    @PostMapping("updateInviteCode")
    public AppResponse updateInviteCode (PersonalInfo personalInfo) {
        try {
            personalInfo.setUserCode(SecurityUtils.getCurrentUserId());
            return personalService.updateInviteCode(personalInfo);
        } catch (Exception e) {
            logger.error("修改门店邀请码失败！");
            System.out.println(e.toString());
            throw e;
        }
    }
}
