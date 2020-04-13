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
     * 新增门店
     * @param storeInfo
     * @return
     */
    int addStore (StoreInfo storeInfo);
}
