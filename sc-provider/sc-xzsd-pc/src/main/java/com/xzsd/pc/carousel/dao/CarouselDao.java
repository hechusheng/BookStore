package com.xzsd.pc.carousel.dao;


import com.xzsd.pc.carousel.entity.CarouselInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName CarouselDao
 * @Description 首页轮播图管理
 * @Author hechusheng
 * @Date 2020-03-30
 */
@Mapper
public interface CarouselDao {
    /**
     * 统计轮播图序号数量
     * @param carouselInfo
     * @return
     */
    int countCaroNum(CarouselInfo carouselInfo);

    /**
     * 统计轮播图商品数量
     * @param carouselInfo
     * @return
     */
    int countCaroCmd(CarouselInfo carouselInfo);

    /**
     * 新增轮播图
     * @param carouselInfo
     * @return
     */
    int addCarousel(CarouselInfo carouselInfo);

    /**
     * 选择商品列表(分页)查询
     * @param carouselInfo
     * @return
     */
    List<CarouselInfo> listComCarouselByPage(CarouselInfo carouselInfo);

    /**
     * 删除轮播图
     * @param listCode
     * @param userId
     * @return
     */
    int deleteCarousel(@Param("listCode") List<String> listCode, @Param("userId") String userId);

    /**
     * 轮播图状态修改（0启用 1禁用）
     * @param listCode
     * @param caroStatus
     * @return
     */
    int updateCaroStatus(@Param("listCode") List<String> listCode, @Param("userId") String userId, @Param("caroStatus") String caroStatus);

    /**
     * 轮播图分页查询
     * @param carouselInfo
     * @return
     */
    List<CarouselInfo> listCarouselByPage(CarouselInfo carouselInfo);
}
