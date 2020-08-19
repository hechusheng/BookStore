package com.xzsd.pc.commoditySort.service;



import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.commoditySort.dao.CmdSortDao;
import com.xzsd.pc.commoditySort.entity.CmdSortInfo;
import com.xzsd.pc.commoditySort.entity.FirstClassSort;
import com.xzsd.pc.commoditySort.entity.SecondClassSort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @DescriptionDemo 实现类
 * @Author hechusheng
 * @Date 2020-03-27
 */
@Service
public class CmdSortService {
    @Resource
    private CmdSortDao cmdSortDao;

    /**
     * 新增商品分类
     * @param cmdSortInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addCommoditySort(CmdSortInfo cmdSortInfo){
        //校验分类是否存在
        int countSortName = cmdSortDao.countSortName(cmdSortInfo);
        if(0 != countSortName){
            return AppResponse.bizError("该分类已存在，请重新输入！");
        }
        cmdSortInfo.setSortCode(StringUtil.getCommonCode(2));
        cmdSortInfo.setIsDelete(0);
        //新增商品分类
        int count = cmdSortDao.addCommoditySort(cmdSortInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败，请重试");
        }
        return AppResponse.success("新增成功！");
    }

    /**
     * 查询分类详情
     * @param sortCode
     * @return
     */
    public AppResponse findSortByCode (String sortCode) {
        CmdSortInfo cmdSortInfo = cmdSortDao.findSortByCode(sortCode);
        return AppResponse.success("查询成功！",cmdSortInfo);
    }

    /**
     * demo 修改商品分类
     * @param cmdSortInfo
     * @return
     * @Author hechusheng
     * @Date 2020-03-27x
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateSort(CmdSortInfo cmdSortInfo) {
        //校验分类是否存在
        int countSortName = cmdSortDao.countSortName(cmdSortInfo);
        if(0 != countSortName){
            return AppResponse.bizError("该分类已存在，请重新输入！");
        }
        // 修改用户信息
        int count = cmdSortDao.updateSort(cmdSortInfo);
        if (0 == count) {
            return AppResponse.versionError("修改失败！");
        }
        return AppResponse.success("修改成功");
    }

    /**
     * demo 查询商品分类列表
     * @return
     * @Author hechusheng
     * @Date 2020-03-27
     */
    public AppResponse listSorts() {
        List<FirstClassSort> firstSortList = cmdSortDao.listSorts();
        return AppResponse.success("查询成功！",firstSortList);
    }

    /**
     * 删除分类
     * @param cmdSortInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteSort (CmdSortInfo cmdSortInfo) {
        //获取分类编号
        CmdSortInfo cmdSort = cmdSortDao.findSortByCode(cmdSortInfo.getSortCode());
        if (cmdSort == null) {
            return AppResponse.bizError("该分类为空");
        }else if (Integer.parseInt(cmdSort.getSortLevel()) == 1){
            //若删除的是一级分类，且有下级分类
            int countChildSort = cmdSortDao.countChildSort(cmdSortInfo.getSortCode());
            if (0 != countChildSort) {
                return AppResponse.bizError("删除失败,改分类存在下级分类");
            }
        }else if (Integer.parseInt(cmdSort.getSortLevel()) == 2) {
            //检查改分类下是否有商品
            int countCmd = cmdSortDao.countCmd(cmdSortInfo.getSortCode());
            if (0 != countCmd){
                return AppResponse.bizError("删除商品二级分类失败，该二级分类下有商品！");
            }
        }
        //删除分类
        int count = cmdSortDao.deleteSort(cmdSortInfo);
        if (0 == count) {
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.success("删除成功");
    }
}
