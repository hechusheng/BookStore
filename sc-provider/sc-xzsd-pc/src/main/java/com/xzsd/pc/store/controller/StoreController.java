package com.xzsd.pc.store.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hechusheng
 * @Descritption增删查改Store
 * @Date 2020-04-12
 */
@RestController
@RequestMapping("/store")
public class StoreController {
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);
    @Resource
    private StoreService storeService;

    /**
     * 新增门店
     * @param storeInfo
     * @return
     */
    @PostMapping("addStore")
    public AppResponse addStore (StoreInfo storeInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setCreateUser(userId);
            storeInfo.setUpdateUser(userId);
            return storeService.addStore(storeInfo);
        }catch (Exception e){
            logger.error("新增热门商品失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
