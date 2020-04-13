package com.xzsd.pc.store.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.StoreInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @DescriptionDemo 实现类
 * @Author hechusheng
 * @Date 2020-04-13
 */
@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;

    /**
     * 新增门店
     * @param storeInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore (StoreInfo storeInfo) {
        //校验门店是否存在
        int countStore = storeDao.countStore(storeInfo);
        if (0 != countStore) {
            return AppResponse.bizError("门店已存在！");
        }
        storeInfo.setStoreCode(StringUtil.getCommonCode(2));
        storeInfo.setIsDelete(0);
        //新增门店
        int count = storeDao.addStore(storeInfo);
        if (0 == count) {
            return AppResponse.bizError("新增门店失败！");
        }
        return AppResponse.success("新增门店成功！");
    }
}
