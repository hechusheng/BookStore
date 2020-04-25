package com.xzsd.pc.commodityHot.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.commodityHot.dao.CmdHotDao;
import com.xzsd.pc.commodityHot.entity.CmdHotInfo;
import com.xzsd.pc.commodityHot.entity.ShowNumInfo;
import com.xzsd.pc.commoditySort.dao.CmdSortDao;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @DescriptionDemo 实现类
 * @Author hechusheng
 * @Date 2020-04-12
 */
@Service
public class CmdHotService {
    @Resource
    private CmdHotDao cmdHotDao;

    /**
     * 新增热门商品
     * @param cmdHotInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addCommodityHot(CmdHotInfo cmdHotInfo) {
        //校验热门商品序号
        int countCmdHot = cmdHotDao.countCmdHotNum(cmdHotInfo);
        if(0 != countCmdHot) {
            return AppResponse.bizError("热门商品新增失败,序号已存在");
        }
        //校验热门商品是否存在
        int countCmdHotNum = cmdHotDao.countCmdHot(cmdHotInfo);
        if(0 != countCmdHotNum) {
            return AppResponse.bizError("热门商品新增失败,商品已存在");
        }
        cmdHotInfo.setHotCode(StringUtil.getCommonCode(2));
        cmdHotInfo.setIsDelete(0);
        int count = cmdHotDao.addCommodityHot(cmdHotInfo);
        if(0 == count){
            return AppResponse.bizError("新增失败");
        }

        return AppResponse.success("新增成功");
    }

    /**
     * 查询热门位商品详情
     * @param hotCode
     * @return
     */
    public AppResponse getCommodityHot (String hotCode) {
        CmdHotInfo cmdHotInfo = cmdHotDao.getCommodityHot(hotCode);
        return AppResponse.success("热门商品详情查询成功",cmdHotInfo);
    }

    /**
     * 修改热门商品
     * @param cmdHotInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateCommodityHot (CmdHotInfo cmdHotInfo) {
        //校验热门商品序号
        int countCmdHot = cmdHotDao.countCmdHotNum(cmdHotInfo);
        if(0 != countCmdHot) {
            return AppResponse.bizError("热门商品修改失败,序号已存在");
        }
        //校验热门商品是否存在
        int countCmdHotNum = cmdHotDao.countCmdHot(cmdHotInfo);
        if(0 != countCmdHotNum) {
            return AppResponse.bizError("热门商品修改失败,商品已存在");
        }
        //修改热门商品
        int count = cmdHotDao.updateCommodityHot(cmdHotInfo);
        if(0 == count) {
            return AppResponse.bizError("热门商品修改失败");
        }
        return AppResponse.success("热门商品修改成功");
    }

    /**
     * 查询热门商品列表(列表)
     * @param cmdHotInfo
     * @return
     */
    public AppResponse listHotCommodityByPage (CmdHotInfo cmdHotInfo) {
        List<CmdHotInfo> cmdHotInfoList = cmdHotDao.listHotCommodityByPage(cmdHotInfo);
        return AppResponse.success("查询热门商品列表成功",getPageInfo(cmdHotInfoList));
    }

    /**
     * 删除热门商品
     * @param hotCode
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteCommodityHot(String hotCode, String userId) {
        //逗号分开（多个删除）
        List<String> listCode = Arrays.asList(hotCode.split(","));
        //删除热门商品
        int count = cmdHotDao.deleteCommodityHot(listCode,userId);
        if(0 == count) {
            return AppResponse.bizError("热门商品删除失败");
        }
        return AppResponse.success("热门商品删除成功");
    }

    /**
     * 展示商品数量
     * @param userId
     * @param showNum
     * @param version
     * @return
     */
    public AppResponse showCommodityHotNum (String userId, String showNum, String version) {
        int result = cmdHotDao.showCommodityHotNum(userId,showNum,version);
        if(0 == result){
            return AppResponse.bizError("设置失败");
        }
        return AppResponse.success("设置成功");
    }

    /**
     * 获取展示数量
     * @return
     */
    public AppResponse getShowNum () {
        ShowNumInfo showNumInfo = cmdHotDao.getShowNum();
        return AppResponse.success("查询成功！",showNumInfo);
    }
}
