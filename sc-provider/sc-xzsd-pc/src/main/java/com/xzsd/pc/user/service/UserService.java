package com.xzsd.pc.user.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.CodeList;
import com.xzsd.pc.util.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author hechusheng
 * @Date 2020-03-24
 */
@Service
public class UserService {

    @Resource
    private UserDao userDao;

    /**
     * demo 新增用户
     * @param userInfo
     * @return
     * @Author hechusheng
     * @Date 2020-03-24
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(UserInfo userInfo){
        //校验账号是否存在
        int countUserAccount = userDao.countUserAccount(userInfo);
        if(0 != countUserAccount){
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        //校验身份证是否被注册
        int countIdCard = userDao.countIdCard(userInfo);
        if  (0 != countIdCard){
            return AppResponse.bizError("身份证已注册，请重新输入！");
        }
        userInfo.setUserCode(StringUtil.getCommonCode(2));
        userInfo.setUserPassword(PasswordUtils.generatePassword(userInfo.getUserPassword()));
        userInfo.setIsDelete(0);
        //如果性别没填，默认为2 (未知)
        if(userInfo.getSex() == null || "".equals(userInfo.getSex()))
        {
            userInfo.setSex("2");
        }
        //如果图片为空，设置默认图片
        if (userInfo.getPhoto() == null || "".equals(userInfo.getPhoto())){
            userInfo.setPhoto("https://lgbryant-1301861090.cos.ap-guangzhou.myqcloud.com/lgbryant/2020/3/16/3af8c649-2d63-4f71-904f-79064c7ed2a8.jpg");
        }
       //新增用户
        int count = userDao.addUser(userInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 修改用户
     * @param userInfo
     * @return
     * @author hechusheng
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUserByCode(UserInfo userInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        UserInfo user = userDao.findUserByCode(userInfo.getUserCode());
        //校验账号是否存在
        int countUserAccount = userDao.countUserAccount(userInfo);
        if(0 != countUserAccount){
            return AppResponse.bizError("用户账号已存在，请重新输入！");
        }
        //校验身份证是否被注册
        int countIdCard = userDao.countIdCard(userInfo);
        if(0 != countIdCard){
            return AppResponse.bizError("身份证已注册，请重新输入！");
        }
        //如果密码没有修改
        if (userInfo.getUserPassword().equals(user.getUserPassword())){
            userInfo.setUserPassword(user.getUserPassword());
        }else{//如果密码修改了
            userInfo.setUserPassword(PasswordUtils.generatePassword(userInfo.getUserPassword()));
        }
        // 修改用户信息
        int count = userDao.updateUserByCode(userInfo);
        if (0 == count) {
            appResponse = AppResponse.versionError("数据有变化，请刷新！");
            return appResponse;
        }
        return appResponse;
    }

    /**
     * demo 查询用户列表（分页）
     * @param userInfo
     * @return
     * @Author hechusheng
     * @Date 2020-03-25
     */
    public AppResponse listUsersByPage(UserInfo userInfo) {
        //查询用户列表(分页)
        List<UserInfo> userInfoList = userDao.listUsersByPage(userInfo);
        return AppResponse.success("查询成功！",getPageInfo(userInfoList));
    }

    /**
     * demo 删除用户
     * @param userCode
     * @return
     * @Author hechusheng
     * @Date 2020-03-25
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteUser(String userCode,String userId) {
        List<String> list = Arrays.asList(userCode.split(","));
        List<String> userCodeList = new ArrayList<>(list);
        int codeSize = userCodeList.size();
        //校验删除的用户中是否有店长拥有门店
        CodeList codeList = new CodeList();
        codeList.setCodeList(userCodeList);
        List<String> checkUserList = userDao.storeCount(codeList);
        // 删除用户
        if (checkUserList != null && checkUserList.size() != 0){
            codeList.setCheckUserList(checkUserList);
        }
        // 删除用户
        codeList.setUserId(userId);
        int count = userDao.deleteUser(codeList);
        if (0 == count) {

            return AppResponse.bizError("删除失败,删除的用户旗下有门店");
        }else if (codeSize != count){
            return AppResponse.success("删除用户成功,存在有门店的用户无法删除");
        }
        return AppResponse.success("删除用户成功！");
    }

    /**
     * demo 查询用户详情
     * @param userCode
     * @return
     * @Author hechusheng
     * @Date 2020-03-25
     */
    public AppResponse findUserByCode (String userCode) {
        UserInfo userInfo = userDao.findUserByCode(userCode);
        return AppResponse.success("查询成功",userInfo);
    }

    /**
     * demo 用户登录
     * @param
     * @return
     * @Author hechusheng
     * @Date 2020-03-26
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse userLogin(String userAccount,String userPassword) {
        //查询登录用户信息
        UserInfo userInfo = userDao.userLogin(userAccount,userPassword);
        return AppResponse.success("查询成功",userInfo);
    }
}
