package com.xzsd.pc.driver.dao;

import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DriverDao {
    /**
     * 统计司机数量
     * @param driverInfo
     * @return
     */
    int countUserAccount (DriverInfo driverInfo);

    /**
     * 统计身份证数量
     * @param driverInfo
     * @return
     */
    int countIdCard (DriverInfo driverInfo);
    /**
     * 新增司机
     * @param driverInfo
     * @return
     */
    int addDriver (DriverInfo driverInfo);
    int addUser (DriverInfo driverInfo);

    /**
     * 查询司机详情
     * @param userCode
     * @return
     */
    DriverInfo findDriverByCode (String userCode);

    /**
     * 修改司机信息
     * @param driverInfo
     * @return
     */
    int updateDriverByCode (DriverInfo driverInfo);
    int updateUserByCode (DriverInfo driverInfo);

    /**
     * 查询司机列表(分页)
     * @param driverInfo
     * @return
     */
    List<DriverInfo> listDriverByPage(DriverInfo driverInfo);

    /**
     * 查询操作人角色
     * @param userCode
     * @return
     */
    UserInfo getUser (String userCode);

    /**
     * 删除司机
     * @param listCode
     * @param userId
     * @return
     */
    int deleteUser(@Param("listCode") List<String> listCode, @Param("userId") String userId);
    int deleteDriver(@Param("listCode") List<String> listCode, @Param("userId") String userId);
}
