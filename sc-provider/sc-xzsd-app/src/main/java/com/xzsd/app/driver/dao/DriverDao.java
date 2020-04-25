package com.xzsd.app.driver.dao;

import com.xzsd.app.driver.entity.StoreInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName  DriverDao
 * @Description 司机端负责店长信息
 * @Author hechusheng
 * @Date 2020-04-21
 */
@Mapper
public interface DriverDao {
    /**
     * 查询司机负责门店
     * @param userCode
     * @return
     */
    List<StoreInfo> listStoreByPage (String userCode);
}
