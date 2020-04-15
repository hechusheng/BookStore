package com.xzsd.pc.driver.dao;

import com.xzsd.pc.driver.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;

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
}
