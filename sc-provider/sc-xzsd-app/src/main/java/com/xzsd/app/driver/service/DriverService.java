package com.xzsd.app.driver.service;

import com.xzsd.app.driver.dao.DriverDao;
import com.xzsd.app.driver.entity.StoreInfo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @ClassName  DriverService
 * @Description 司机端负责店长信息实现层
 * @Author hechusheng
 * @Date 2020-04-21
 */
@Service
public class DriverService {
    @Resource
    private DriverDao driverDao;

    /**
     * 查询司机负责门店
     * @param userCode
     * @return
     */
    public AppResponse listStoreByPage (String userCode) {
        List<StoreInfo> storeInfoList = driverDao.listStoreByPage(userCode);
        return AppResponse.success("查询门店成功！",getPageInfo(storeInfoList));
    }
}
