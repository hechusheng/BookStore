package com.xzsd.app.client.registered.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.client.registered.eneity.UserInfo;
import com.xzsd.app.client.registered.service.RegService;
import com.xzsd.app.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName RegController
 * @Description 新增用户(注册)
 * @Author hechusheng
 * @Date 2020-04-17
 */
@RestController
@RequestMapping("/clientRegistered")
public class RegController {
    private static final Logger logger = LoggerFactory.getLogger(RegController.class);
    @Resource
    private RegService regService;

    /**
     * 用户注册
     * @param userInfo
     * @return
     */
    @PostMapping("addUser")
    public AppResponse addUser (UserInfo userInfo) {
        try {
            return regService.adduser(userInfo);
        } catch (Exception e) {
            logger.error("注册失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
