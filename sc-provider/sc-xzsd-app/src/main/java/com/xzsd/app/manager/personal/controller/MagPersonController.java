package com.xzsd.app.manager.personal.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.manager.personal.service.MagPersonService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName  MagPersonController
 * @Description 店长端个人信息控制层
 * @Author hechusheng
 * @Date 2020-04-21
 */
@RestController
@RequestMapping("/manager")
public class MagPersonController {
    private static final Logger logger = LoggerFactory.getLogger(MagPersonController.class);

    @Resource
    private MagPersonService magPersonService;

    /**
     * 查询门店附近司机
     * @return
     */
    @RequestMapping("listDriver")
    public AppResponse listDriver() {
        try {
            String userCode = SecurityUtils.getCurrentUserId();
            return magPersonService.listDriver(userCode);
        } catch (Exception e) {
            logger.error("查询门店附近司机失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
