package com.xzsd.app.client.registered.service;

import com.xzsd.app.client.registered.dao.RegDao;
import com.xzsd.app.client.registered.eneity.UserInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.PasswordUtils;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @ClassName RegService
 * @Description 新增用户(注册)
 * @Author hechusheng
 * @Date 2020-04-17
 */
@Service
public class RegService {
    @Resource
    private RegDao regDao;

    /**
     * 用户注册
     * @param userInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse adduser (UserInfo userInfo) {
        //校验用户账户是否存在
        int countUserAccount = regDao.countUserAccount(userInfo);
        if (0 != countUserAccount) {
            return AppResponse.bizError("用户账户重复！");
        }
        //校验身份证是否存在
        int countIdCard = regDao.countIdCard(userInfo);
        if (0 != countIdCard) {
            return AppResponse.bizError("该身份证已被注册");
        }
        //校验门店邀请码是否存在
        int countInviteCode = regDao.countInviteCode(userInfo);
        if (0 == countInviteCode) {
            return AppResponse.bizError("门店邀请码不存在");
        }
        userInfo.setUserCode(StringUtil.getCommonCode(2));
        userInfo.setUserPassword(PasswordUtils.generatePassword(userInfo.getUserPassword()));
        //如果图片为空，设置默认图片
        if(userInfo.getPhoto() == null || "".equals(userInfo.getPhoto())){
            userInfo.setPhoto("https://lgbryant-1301861090.cos.ap-guangzhou.myqcloud.com/lgbryant/2020/3/16/3af8c649-2d63-4f71-904f-79064c7ed2a8.jpg");
        }
        userInfo.setIsDelete(0);
        //注册
        int countUser = regDao.addUser(userInfo);
        int countUserClient = regDao.addUserClient(userInfo);
        if (0 == countUser || 0 == countUserClient) {
            return AppResponse.bizError("注册失败！");
        }
        return AppResponse.success("注册成功");
    }
}
