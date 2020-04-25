package com.xzsd.pc.driver.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.service.DriverService;
import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/userDriver")
public class DriverController {
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);
    @Resource
    private DriverService driverService;

    /**
     * 新增司机
     * @param driverInfo
     * @return
     */
    @PostMapping("addDriver")
    public AppResponse addDriver (DriverInfo driverInfo) {
        try {
            //获取操作人编号
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setUserId(userId);
            driverInfo.setCreateUser(userId);
            return driverService.addDriver(driverInfo);
        }catch (Exception e) {
            logger.error("新增司机失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询司机详情
     * @param userCode
     * @return
     */
    @RequestMapping("findDriverByCode")
    public AppResponse findDriverByCode (String userCode) {
        try {
            return driverService.findDriverByCode(userCode);
        }catch (Exception e) {
            logger.error("查询司机详情失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 修改司机信息
     * @param driverInfo
     * @return
     */
    @PostMapping("updateDriverByCode")
    public AppResponse updateDriverByCode (DriverInfo driverInfo){
        try {
            //获取操作人编号
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setUpdateUser(userId);
            return driverService.updateDriverByCode(driverInfo);
        }catch (Exception e) {
            logger.error("修改司机信息失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 查询司机列表(分页)
     * @param driverInfo
     * @return
     */
    @RequestMapping("listDriverByPage")
    public AppResponse listDriverByPage (DriverInfo driverInfo) {
        try {
            //获取操作人编号
            String userId = SecurityUtils.getCurrentUserId();
            driverInfo.setUserId(userId);
            //查询司机列表
            return driverService.listDriverByPage(driverInfo);
        }catch (Exception e) {
            logger.error("查询司机列表失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

    /**
     * 删除司机
     * @param userCode
     * @return
     */
    @PostMapping("deleteDriver")
    public AppResponse deleteDriver(String userCode){
        try{
            //获取操作人编号
            String userId = SecurityUtils.getCurrentUserId();
            return driverService.deleteDriver(userCode,userId);
        }catch (Exception e){
            logger.error("删除失败");
            System.out.println(e.toString());
            throw e;
        }
    }
}
