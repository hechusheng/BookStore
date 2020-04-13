package com.xzsd.pc.store.dao;

import com.xzsd.pc.store.entity.StoreInfo;
import org.apache.ibatis.annotations.Mapper;

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
}
