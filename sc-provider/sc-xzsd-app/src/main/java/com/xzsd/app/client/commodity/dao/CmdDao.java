package com.xzsd.app.client.commodity.dao;

import com.xzsd.app.client.commodity.entity.CmdAssess;
import com.xzsd.app.client.commodity.entity.CmdInfo;
import com.xzsd.app.client.commodity.entity.FirstClassSort;
import com.xzsd.app.client.commodity.entity.SecondClassSort;
import com.xzsd.app.client.orderform.entity.AssessInfo;
import com.xzsd.app.client.orderform.entity.OrderAssess;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @ClassName CmdDao
 * @Description 商品信息管理
 * @Author hechusheng
 * @Date 2020-04-17
 */
@Mapper
public interface CmdDao {
    /**
     * 查询商品详情
     * @param comCode
     * @return
     */
    CmdInfo getCommodity (String comCode);

    /**
     * 查询商品一级分类
     * @return
     */
    List<FirstClassSort> firstClassList ();

    /**
     * 查询商品二级分类及其商品信息
     * @param firstSortCode
     * @return
     */
    List<SecondClassSort> secondClassList (String firstSortCode);

    /**
     * 查询商品评价列表(分页)
     * @param cmdAssess
     * @return
     */
    List<CmdAssess> listCommodityAssessByPage(CmdAssess cmdAssess);
}
