package com.xzsd.pc.driver.service;

import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.util.AppResponse;
import com.xzsd.pc.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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
}
