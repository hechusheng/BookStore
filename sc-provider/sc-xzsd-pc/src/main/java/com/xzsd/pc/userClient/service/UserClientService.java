package com.xzsd.pc.userClient.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.userClient.dao.UserClientDao;
import com.xzsd.pc.userClient.entity.UserClientInfo;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author hechusheng
 * @Date 2020-03-30
 */
@Service
public class UserClientService {
    @Resource
    private UserClientDao userClientDao;
    @Resource
    private UserDao userDao;

    /**
     * 查询客户列表
     * @param userClientInfo
     * @return
     */
    public AppResponse listUserClientByPage(UserClientInfo userClientInfo) {
        //获取用户角色
        UserInfo userInfo = userDao.findUserByCode(userClientInfo.getUserId());
        String count = null;
        if (userInfo.getRole().equals("1")) {
            count = userClientDao.getInvCode(userClientInfo.getUserId());
        }
        if (null != count) {
            userClientInfo.setInviteCode(count);
        }
        //查询客户
        List<UserClientInfo> userClientInfos = userClientDao.listUserClientByPage(userClientInfo);
        return AppResponse.success("查询客户成功",getPageInfo(userClientInfos));
    }
}
