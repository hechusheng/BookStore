package com.xzsd.app.manager.personal.service;

import com.xzsd.app.manager.personal.dao.MagPersonDao;
import com.xzsd.app.manager.personal.entity.DriverInfo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName  PersonalService
 * @Description 店长端个人信息实现层
 * @Author hechusheng
 * @Date 2020-04-21
 */
@Service
public class MagPersonService {
    @Resource
    private MagPersonDao magPersonDao;

    /**
     * 查询店长门下司机
     * @param userCode
     * @return
     */
    public AppResponse listDriver(String userCode) {
        List<DriverInfo> driverInfoList = magPersonDao.listDriver(userCode);
        return AppResponse.success("查询成功",driverInfoList);
    }
}
