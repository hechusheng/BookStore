package com.xzsd.pc.store.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.commoditySort.entity.FirstClassSort;
import com.xzsd.pc.menu.dao.MenuDao;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.AreaInfo;
import com.xzsd.pc.store.entity.CityInfo;
import com.xzsd.pc.store.entity.ProvinceInfo;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.RandomUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author hechusheng
 * @Date 2020-04-13
 */
@Service
public class StoreService {
    @Resource
    private StoreDao storeDao;
    @Resource
    private MenuDao menuDao;
    /**
     * 新增门店
     * @param storeInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore (StoreInfo storeInfo) {
        //校验门店邀请码/营业执照是否存在
        int countStore = storeDao.countStore(storeInfo);
        if (0 != countStore) {
            return AppResponse.bizError("邀请码/营业执照已存在！");
        }
        //校验店长是否存在
        int countUserCode = storeDao.countUserCode(storeInfo);
        if (0 == countUserCode) {
            return AppResponse.bizError("店长编号不存在！");
        }
        storeInfo.setStoreCode(StringUtil.getCommonCode(2));
        storeInfo.setInviteCode(RandomUtil.getRandomString(6));
        storeInfo.setIsDelete(0);
        //新增门店
        int count = storeDao.addStore(storeInfo);
        if (0 == count) {
            return AppResponse.bizError("新增门店失败！");
        }
        return AppResponse.success("新增门店成功！");
    }

    /**
     * 查询门店详情
     * @param storeCode
     * @return
     */
    public AppResponse findStoreByCode (String storeCode) {
        //查询门店详情
        StoreInfo storeInfo = storeDao.findStoreByCode(storeCode);
        return AppResponse.success("查询门店详情成功！",storeInfo);
    }

    /**
     * 修改门店信息
     * @param storeInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStoreByCode (StoreInfo storeInfo) {
        //校验门店邀请码/营业执照是否存在
        int countStore = storeDao.countStore(storeInfo);
        if (0 != countStore) {
            return AppResponse.bizError("邀请码/营业执照已存在！");
        }
        //修改门店
        int count = storeDao.updateStoreByCode(storeInfo);
        if(0 == count) {
            return AppResponse.bizError("修改门店失败!");
        }
        return AppResponse.success("修改门店成功");
    }

    /**
     * 查询门店信息列表(分页)
     * @param storeInfo
     * @return
     */
    public AppResponse listStoreByPage (StoreInfo storeInfo) {
        //获取操作人的用户角色
        UserInfo userInfo = storeDao.getUser(storeInfo.getUserId());
        if (userInfo != null && userInfo.getRole() != null){
            storeInfo.setRole(userInfo.getRole());
        }
        System.out.println(storeInfo.getRole());
        List<StoreInfo> storeInfoList = storeDao.listStoreByPage(storeInfo);
        return AppResponse.success("查询门店列表成功！",getPageInfo(storeInfoList));
    }

    /**
     * 删除门店
     * @param storeCode
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteStore(String storeCode,String userId) {
        List<String> listCode = Arrays.asList(storeCode.split(","));
        AppResponse appResponse = AppResponse.success("删除成功！");
        // 删除门店
        int count = storeDao.deleteStore(listCode,userId);
        if(0 == count) {
            appResponse = AppResponse.bizError("删除失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 省下拉查询
     * @return
     */
    public AppResponse listProvince () {
        List<ProvinceInfo> provinceList = storeDao.listProvince();
        return AppResponse.success("省下拉查询成功",provinceList);
    }

    /**
     * 市下拉查询
     * @param provinceCode
     * @return
     */
    public AppResponse listCity (String provinceCode) {
        List<CityInfo> cityList = storeDao.listCity(provinceCode);
        return AppResponse.success("市下拉查询成功",cityList);
    }

    /**
     * 区/县下拉查询
     * @param cityCode
     * @return
     */
    public AppResponse listArea (String cityCode) {
        List<AreaInfo> areaList = storeDao.listArea(cityCode);
        return AppResponse.success("市下拉查询成功",areaList);
    }
}
