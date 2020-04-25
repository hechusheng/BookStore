package com.xzsd.pc.commodityHot.dao;

import com.xzsd.pc.commodityHot.entity.CmdHotInfo;
import com.xzsd.pc.commodityHot.entity.ShowNumInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @ClassName CmdHotDao
 * @Description 热门商品管理
 * @Author hechusheng
 * @Date 2020-04-12
 */
@Mapper
public interface CmdHotDao {
    /**
     * 统计热门商品
     * @param cmdHotInfo
     * @return
     */
    int countCmdHot(CmdHotInfo cmdHotInfo);

    /**
     * 统计热门商品序号
     * @param cmdHotInfo
     * @return
     */
    int countCmdHotNum(CmdHotInfo cmdHotInfo);
    /**
     * 新增热门商品
     * @param cmdHotInfo
     * @return
     */
    int addCommodityHot(CmdHotInfo cmdHotInfo);

    /**
     * 查询热门商品详情
     * @param hotCode
     * @return
     */
    CmdHotInfo getCommodityHot (String hotCode);

    /**
     * 修改热门商品
     * @param cmdHotInfo
     * @return
     */
    int updateCommodityHot (CmdHotInfo cmdHotInfo);

    /**
     * 查询热门商品列表(分页)
     * @param cmdHotInfo
     * @return
     */
    List<CmdHotInfo> listHotCommodityByPage (CmdHotInfo cmdHotInfo);

    /**
     * 删除热门商品
     * @param listCode
     * @param userId
     * @return
     */
    int deleteCommodityHot (@Param("listCode")List<String> listCode, @Param("userId") String userId);

    /**
     * 展示商品数量设置
     * @param userId
     * @param showNum
     * @param version
     * @return
     */
    int showCommodityHotNum (@Param("userId")String userId,@Param("showNum")String showNum, @Param("version")String version);

    /**
     * 获取展示数量
     * @param
     * @return
     */
    ShowNumInfo getShowNum ();
}
