package com.xzsd.app.client.commodity.service;

import com.xzsd.app.client.commodity.dao.CmdDao;
import com.xzsd.app.client.commodity.entity.CmdAssess;
import com.xzsd.app.client.commodity.entity.CmdInfo;
import com.xzsd.app.client.commodity.entity.FirstClassSort;
import com.xzsd.app.client.commodity.entity.SecondClassSort;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @ClassName CmdInfo
 * @Description 查询商品信息实现类
 * @Author hechusheng
 * @Date 2020-04-17
 */
@Service
public class CmdService {
    @Resource
    private CmdDao cmdDao;

    /**
     * 查询商品详情
     * @param comCode
     * @return
     */
    public AppResponse getCommodity (String comCode) {
        //查询
        CmdInfo cmdInfo = cmdDao.getCommodity(comCode);
        return AppResponse.success("商品详情查询成功！",cmdInfo);
    }

    /**
     * 查询商品一级分类
     * @return
     */
    public AppResponse listFirstClass () {
        List<FirstClassSort> firstClassSortList = cmdDao.firstClassList();
        return AppResponse.success("查询一级分类成功！",firstClassSortList);
    }

    /**
     * 查询商品二级分类及其商品信息
     * @param firstSortCode
     * @return
     */
    public AppResponse listSecondClass (String firstSortCode) {
        List<SecondClassSort> secondClassSorts = cmdDao.secondClassList(firstSortCode);
        return AppResponse.success("查询二级分类及其商品信息成功！",secondClassSorts);
    }

    /**
     * 查询商品评价列表(分页)
     * @param cmdAssess
     * @return
     */
    public AppResponse listCommodityAssessByPage (CmdAssess cmdAssess) {
        List<CmdAssess> cmdAssessList = cmdDao.listCommodityAssessByPage(cmdAssess);
        return AppResponse.success("查询商品评价成功！", getPageInfo(cmdAssessList));
    }
}
