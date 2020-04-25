package com.xzsd.app.manager.personal.dao;

import com.xzsd.app.manager.personal.entity.DriverInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName  PersonalDao
 * @Description 店长端个人信息
 * @Author hechusheng
 * @Date 2020-04-21
 */
@Mapper
public interface MagPersonDao {
    /**
     * 查询店长门下司机信息
     * @param userCode
     * @return
     */
    List<DriverInfo> listDriver (String userCode);
}
