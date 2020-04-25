package com.xzsd.pc.topBar.controller;

import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.topBar.service.TopBarService;

import com.xzsd.pc.util.AppResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hechusheng
 * @Descritption查询用户信息(顶部栏)
 * @Date 2020-04-13
 */
@RestController
@RequestMapping("/topBar")
public class TopBarController {
    private static final Logger logger = LoggerFactory.getLogger(TopBarController.class);
    @Resource
    private TopBarService topBarService;
    @RequestMapping("getTopBar")
    public AppResponse getTopBar(){
        try{
            //获取操作人编号
            String userCode = SecurityUtils.getCurrentUserId();
            return topBarService.getTopBar(userCode);
        }catch (Exception e){
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
