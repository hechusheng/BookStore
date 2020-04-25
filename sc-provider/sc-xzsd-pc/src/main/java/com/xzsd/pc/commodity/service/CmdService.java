package com.xzsd.pc.commodity.service;



import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.commodity.dao.CmdDao;
import com.xzsd.pc.commodity.entity.CmdInfo;
import com.xzsd.pc.commoditySort.entity.CmdSortInfo;
import com.xzsd.pc.commoditySort.entity.FirstClassSort;
import com.xzsd.pc.commoditySort.entity.SecondClassSort;
import com.xzsd.pc.util.CodeList;
import com.xzsd.pc.util.ListCode;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author hechusheng
 * @Date 2020-03-24
 */
@Service
public class CmdService {
    @Resource
    private CmdDao cmdDao;

    /**
     * demo 新增商品
     * @param cmdInfo
     * @return
     * @Author hechusheng
     * @Date 2020-03-27
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addCommodity(CmdInfo cmdInfo){
        //校验商品是否存在
        int countCommodity = cmdDao.countCommodity(cmdInfo);
        if(0 != countCommodity){
            return AppResponse.bizError("商品已存在，请重新输入！");
        }
        cmdInfo.setComCode(StringUtil.getCommonCode(2));
        //如果图片为空，设置默认图片
        if( cmdInfo.getPicPath() == null || "".equals(cmdInfo.getPicPath())){
            cmdInfo.setPicPath("https://lgbryant-1301861090.cos.ap-guangzhou.myqcloud.com/lgbryant/2020/3/16/3af8c649-2d63-4f71-904f-79064c7ed2a8.jpg");
        }
        cmdInfo.setStarLevel(0);
        cmdInfo.setIsDelete(0);
        cmdInfo.setComStatus("2");
        //新增商品
        int count = cmdDao.addCommodity(cmdInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * demo 查询商品列表（分页）
     * @param cmdInfo
     * @return
     * @Author hechusheng
     * @Date 2020-03-27
     */
    public AppResponse listCommodityByPage(CmdInfo cmdInfo) {
        List<CmdInfo> cmdInfoList = cmdDao.listCommodity(cmdInfo);
        return AppResponse.success("查询成功！",getPageInfo(cmdInfoList));
    }

    /**
     * demo 修改商品
     * @param cmdInfo
     * @return
     * @Author hechusheng
     * @Date 2020-03-27
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateCommodityByCode (CmdInfo cmdInfo) {
        //校验商品是否存在
        int countCommodity = cmdDao.countCommodity(cmdInfo);
        if(0 != countCommodity){
            return AppResponse.bizError("商品已存在，请重新输入！");
        }
        //修改商品
        int count = cmdDao.updateCommodityByCode(cmdInfo);
        if(0 == count){
            return AppResponse.bizError("修改失败，请重试");
        }
        return AppResponse.success("修改成功！");
    }

    /**
     * 删除商品
     * @param comCode
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteCommodity(String comCode,String userId) {
        List<String> list = Arrays.asList(comCode.split(","));
        List<String> comCodeList = new ArrayList<>(list);
        int codeSize = comCodeList.size();
        //校验商品是否热门商品或轮播图
        CodeList codeList = new CodeList();
        codeList.setCodeList(comCodeList);
        List<String> checkHotList = cmdDao.hotCmdCount(codeList);
        List<String> checkCaroList = cmdDao.caroselCount(codeList);
        // 删除商品
        if (checkHotList != null && checkHotList.size() != 0){
            codeList.setCheckHotList(checkHotList);
        }
        if (checkCaroList != null && checkCaroList.size() != 0){
            codeList.setCheckCaroList(checkCaroList);
        }
        int count = cmdDao.deleteCommodity(codeList);
        if (0 == count) {
           return AppResponse.bizError("删除失败，请重试！");
        }else if (codeSize != count){
            return AppResponse.success("删除商品成功,存在轮播图、热门商品无法删除");
        }
        return AppResponse.success("删除商品成功！");
    }

    /**
     * 查询商品详情
     * @param comCode
     * @return
     * @Author hechusheng
     * @Date 2020-03-27
     */
    public AppResponse findCommodityByCode (String comCode) {
        CmdInfo cmdInfo = cmdDao.findCommodityByCode(comCode);
        return AppResponse.success("查询成功",cmdInfo);
    }

    /**
     * demo 修改商品上架/下架
     * @param comCode
     * @param userId
     * @return
     * @Author hechusheng
     * @Date 2020-03-27
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateComStatus (String comCode,String userId,String comStatus) {
        List<String> listCode = Arrays.asList(comCode.split(","));
        AppResponse appResponse = AppResponse.success("商品状态修改成功！");
        //修改商品
        int count = cmdDao.updateComStatus(listCode,userId,comStatus);
        if(0 == count){
            appResponse = AppResponse.bizError("商品状态修改失败，请重试！");
        }
        return appResponse;
    }

    /**
     * 一级分类下拉查询
     * @return
     * @Author hechusheng
     * @Date 2020-03-27
     */
    public AppResponse listFirstClass () {
        //查询一级分类
        List<FirstClassSort> firstClassList = cmdDao.listFirstClass();
        return AppResponse.success("一级分类查询成功",firstClassList);
    }

    /**
     * 二级分类下拉查询
     * @return
     * @Author hechusheng
     * @Date 2020-03-27
     */
    public AppResponse listSecondClass (String firstSortCode) {
        //查询二级分类
        List<SecondClassSort> secondClassList = cmdDao.listSecondClass(firstSortCode);
        return AppResponse.success("二级分类查询成功",secondClassList);
    }
}



