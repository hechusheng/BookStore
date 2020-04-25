package com.xzsd.app.client.index.dao;

import com.xzsd.app.client.index.entity.CarouselInfo;
import com.xzsd.app.client.index.entity.CmdHotInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName IndexDao
 * @Description 客户端首页管理
 * @Author hechusheng
 * @Date 2020-04-17
 */
@Mapper
public interface IndexDao {
    /**
     * 首页轮播图查询
     * @return
     */
    List<CarouselInfo> listCarousel();

    /**
     * 首页热门商品查询
     * @return
     */
    List<CmdHotInfo> listCommodityHot (int count);
    /**
     * 获取展示数量
     * @param
     * @return
     */
    int getShowNum ();
}
