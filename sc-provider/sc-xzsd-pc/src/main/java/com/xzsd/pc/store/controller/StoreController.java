package com.xzsd.pc.store.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.AuthUtils;
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
            logger.error("新增门店失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询门店详情
     * @param storeCode
     * @return
     */
    @RequestMapping("findStoreByCode")
    public AppResponse findStoreByCode (String storeCode) {
        try {
            return storeService.findStoreByCode(storeCode);
        }catch (Exception e){
            logger.error("查询门店失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改门店信息
     * @param storeInfo
     * @return
     */
    @PostMapping("updateStoreByCode")
    public AppResponse updateStoreByCode (StoreInfo storeInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setUpdateUser(userId);
            return storeService.updateStoreByCode(storeInfo);
        }catch (Exception e){
            logger.error("修改门店失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询门店信息列表(分页)
     * @param storeInfo
     * @return
     */
    @RequestMapping("listStoreByPage")
    public AppResponse listStoreByPage (StoreInfo storeInfo) {
        try {
            String userId = SecurityUtils.getCurrentUserId();
            storeInfo.setUserId(userId);
            return storeService.listStoreByPage(storeInfo);
        }catch (Exception e){
            logger.error("查询门店信息列表失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除门店
     * @param storeCode
     * @return
     */
    @PostMapping("deleteStore")
    public AppResponse deleteStore(String storeCode) {
        try {
            //获取用户id
            String userId = SecurityUtils.getCurrentUserId();
            return storeService.deleteStore(storeCode,userId);
        } catch (Exception e) {
            logger.error("门店删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询省份列表
     * @return
     */
    @RequestMapping("listProvince")
    public AppResponse listProvince(){
        try{
            AppResponse appResponse = storeService.listProvince();
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询城市列表
     * @param provinceCode
     * @return
     */
    @RequestMapping("listCity")
    public AppResponse listCity(String provinceCode){
        try{
            AppResponse appResponse = storeService.listCity(provinceCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询区列表
     * @param cityCode
     * @return
     */
    @RequestMapping("listArea")
    public AppResponse listArea(String cityCode){
        try{
            AppResponse appResponse = storeService.listArea(cityCode);
            return appResponse;
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
