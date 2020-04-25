package com.xzsd.app.client.index.service;

import com.xzsd.app.client.index.dao.IndexDao;
import com.xzsd.app.client.index.entity.CarouselInfo;
import com.xzsd.app.client.index.entity.CmdHotInfo;
import com.xzsd.app.client.index.entity.ShowNumInfo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName IndexService
 * @Description 客户端首页管理
 * @Author hechusheng
 * @Date 2020-04-17
 */
@Service
public class IndexService {
    @Resource
    private IndexDao indexDao;

    /**
     * 查询首页轮播图列表
     * @return
     */
    public AppResponse ListCarousel () {
        //查询首页轮播图列表
        List<CarouselInfo> carouselInfoList = indexDao.listCarousel();
        return AppResponse.success("查询成功",carouselInfoList);
    }

    /**
     * 查询首页热门商品
     * @return
     */
    public AppResponse listCommodityHot () {
        int count = Integer.valueOf(indexDao.getShowNum());
        //查询首页热门商品列表
        List<CmdHotInfo> cmdHotInfoList = indexDao.listCommodityHot(count);
        return AppResponse.success("查询成功",cmdHotInfoList);
    }

}
