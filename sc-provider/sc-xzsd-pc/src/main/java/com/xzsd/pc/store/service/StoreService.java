package com.xzsd.pc.store.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.util.RandomUtil;
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
        //校验门店邀请码/营业执照是否存在
        int countStore = storeDao.countStore(storeInfo);
        if (0 != countStore) {
            return AppResponse.bizError("邀请码/营业执照已存在！");
        }
        //校验店长是否存在
        int countUserCode = storeDao.countUserCode(storeInfo);
        if (0 == countUserCode) {
            return AppResponse.bizError("店长编号不存在！");
        }
        storeInfo.setStoreCode(StringUtil.getCommonCode(2));
        storeInfo.setInviteCode(RandomUtil.getRandomString(6));
        storeInfo.setIsDelete(0);
        //新增门店
        int count = storeDao.addStore(storeInfo);
        if (0 == count) {
            return AppResponse.bizError("新增门店失败！");
        }
        return AppResponse.success("新增门店成功！");
    }

    /**
     * 查询门店详情
     * @param storeCode
     * @return
     */
    public AppResponse findStoreByCode (String storeCode) {
        //查询门店详情
        StoreInfo storeInfo = storeDao.findStoreByCode(storeCode);
        return AppResponse.success("查询门店详情成功！",storeInfo);
    }

    /**
     * 修改门店信息
     * @param storeInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStoreByCode (StoreInfo storeInfo) {
        //校验门店邀请码/营业执照是否存在
        int countStore = storeDao.countStore(storeInfo);
        if (0 != countStore) {
            return AppResponse.bizError("邀请码/营业执照已存在！");
        }
        //修改门店
        int count = storeDao.updateStoreByCode(storeInfo);
        if(0 == count) {
            return AppResponse.bizError("修改门店失败!");
        }
        return AppResponse.success("修改门店成功");
    }
}
