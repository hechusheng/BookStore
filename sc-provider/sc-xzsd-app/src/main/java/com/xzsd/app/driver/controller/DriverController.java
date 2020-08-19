package com.xzsd.app.driver.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driver.service.DriverService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/driverIndex")
public class DriverController {
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);

    @Resource
    private DriverService driverService;

    @RequestMapping("listStoreByPage")
    public AppResponse listStore () {
        try {
            String userCode = SecurityUtils.getCurrentUserId();
            return driverService.listStoreByPage(userCode);
        } catch (Exception e) {
            logger.error("查询门店失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
