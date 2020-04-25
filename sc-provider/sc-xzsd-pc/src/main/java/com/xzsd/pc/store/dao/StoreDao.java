package com.xzsd.pc.store.dao;

import com.xzsd.pc.store.entity.AreaInfo;
import com.xzsd.pc.store.entity.CityInfo;
import com.xzsd.pc.store.entity.ProvinceInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * @ClassName StoreDao
 * @Description 门店管理
 * @Author hechusheng
 * @Date 2020-4-13
 */
@Mapper
public interface StoreDao {
    /**
     * 统计门店数量
     * @param storeInfo
     * @return
     */
    int countStore (StoreInfo storeInfo);

    /**
     * 统计店长数量
     * @param storeInfo
     * @return
     */
    int countUserCode(StoreInfo storeInfo);

    /**
     * 新增门店
     * @param storeInfo
     * @return
     */
    int addStore (StoreInfo storeInfo);

    /**
     * 查询门店详情
     * @param storeCode
     * @return
     */
    StoreInfo findStoreByCode (String storeCode);

    /**
     * 修改门店信息
     * @param storeInfo
     * @return
     */
    int updateStoreByCode (StoreInfo storeInfo);

    /**
     * 查询门店信息列表(分页)
     * @param storeInfo
     * @return
     */
    List<StoreInfo> listStoreByPage (StoreInfo storeInfo);

    /**
     * 删除门店
     * @param listCode
     * @param userId
     * @return
     */
    int deleteStore(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    /**
     * 省下拉查询
     * @return
     */
    List<ProvinceInfo> listProvince ();

    /**
     * 市下拉查询
     * @param provinceCode
     * @return
     */
    List<CityInfo> listCity (String provinceCode);

    /**
     * 区/县下拉查询
     * @param cityCode
     * @return
     */
    List<AreaInfo> listArea (String cityCode);

    /**
     * 查询操作人角色
     * @param userId
     * @return
     */
    UserInfo getUser (String userId);
}
