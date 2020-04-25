package com.xzsd.pc.topBar.service;

import com.xzsd.pc.topBar.dao.TopBarDao;
import com.xzsd.pc.topBar.entity.TopBarInfo;
import com.xzsd.pc.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TopBarService {
    @Resource
    private TopBarDao topBarDao;

    /**
     * 查询用户信息
     * @return
     */
    public AppResponse getTopBar(String userCode){
        TopBarInfo topBarInfo = topBarDao.getTopBar(userCode);
        return AppResponse.success("查询成功！",topBarInfo);
    }
}
