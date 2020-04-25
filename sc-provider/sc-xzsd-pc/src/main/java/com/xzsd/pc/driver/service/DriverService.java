package com.xzsd.pc.driver.service;

import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.PasswordUtils;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author hechusheng
 * @Date 2020-04-14
 */
@Service
public class DriverService {
    @Resource
    private DriverDao driverDao;

    /**
     * 新增司机
     * @param driverInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addDriver (DriverInfo driverInfo) {
        //校验司机是否存在
        int countIfDriver = driverDao.countUserAccount(driverInfo);
        if (0 != countIfDriver) {
            return AppResponse.bizError("司机账号已存在!");
        }
        //校验身份证是否被注册
        int countIdCard = driverDao.countIdCard(driverInfo);
        if (0 != countIdCard) {
            return AppResponse.bizError("该身份证已被注册!");
        }
        driverInfo.setUserCode(StringUtil.getCommonCode(2));
        driverInfo.setUserPassword(PasswordUtils.generatePassword(driverInfo.getUserPassword()));
        if (driverInfo.getPhoto() == null || "".equals(driverInfo.getPhoto())) {
           driverInfo.setPhoto("https://lgbryant-1301861090.cos.ap-guangzhou.myqcloud.com/lgbryant/2020/3/16/3af8c649-2d63-4f71-904f-79064c7ed2a8.jpg");
        }
        driverInfo.setIsDelete(0);
        //新增司机
        int countUser = driverDao.addUser(driverInfo);
        int countDriver = driverDao.addDriver(driverInfo);
        if (0 == countDriver || 0 == countUser) {
            return AppResponse.bizError("新增司机失败！");
        }
        return AppResponse.success("新增司机成功！");
    }

    /**
     * 查询司机详情
     * @param userCode
     * @return
     */
    public AppResponse findDriverByCode (String userCode) {
        DriverInfo driverInfo = driverDao.findDriverByCode(userCode);
        return  AppResponse.success("查询司机详情成功！",driverInfo);
    }

    /**
     * 修改司机信息
     * @param driverInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriverByCode (DriverInfo driverInfo) {
        //校验账号是否存在
        int countIfDriver = driverDao.countUserAccount(driverInfo);
        if (0 != countIfDriver) {
            return AppResponse.bizError("司机账号已存在!");
        }
        //校验身份证是否被注册
        int countIdCard = driverDao.countIdCard(driverInfo);
        if (0 != countIdCard) {
            return AppResponse.bizError("该身份证已被注册!");
        }
        //修改司机信息
        int countUser = driverDao.updateUserByCode(driverInfo);
        int countDriver = driverDao.updateDriverByCode(driverInfo);
        if (0 == countDriver || 0 == countUser) {
            return AppResponse.bizError("修改司机信息失败");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * 查询司机列表(分页)
     * @param driverInfo
     * @return
     */
    public AppResponse listDriverByPage (DriverInfo driverInfo) {
        //获取操作人的角色
        UserInfo userInfo = driverDao.getUser(driverInfo.getUserId());
        if(userInfo != null && userInfo.getRole() != null){
            driverInfo.setRole(userInfo.getRole());
        }
        //查询司机列表
        List<DriverInfo> driverInfoList = driverDao.listDriverByPage(driverInfo);
        return AppResponse.success("查询司机列表成功！",getPageInfo(driverInfoList));
    }

    /**
     * 删除司机
     * @param userCode
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteDriver(String userCode, String userId) {
        List<String> listCode = Arrays.asList(userCode.split(","));
        // 删除门店
        int countUser = driverDao.deleteUser(listCode,userId);
        int countDriver = driverDao.deleteDriver(listCode,userId);
        if(0 == countUser || 0 == countDriver) {
            return AppResponse.bizError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }
}
