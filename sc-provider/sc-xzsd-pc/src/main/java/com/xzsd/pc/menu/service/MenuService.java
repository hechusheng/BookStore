package com.xzsd.pc.menu.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.menu.dao.MenuDao;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.util.RoleUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.xzsd.pc.util.RoleUtil.MANAGER;

/**
 * @DescriptionDemo 实现类
 * @Author hechusheng
 * @Date 2020-04-10
 */
@Service
public class MenuService {
    @Resource
    private MenuDao menuDao;
    /**
     * 新增菜单
     * @param menuInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addMenu(MenuInfo menuInfo){
        //校验菜单是否存在
        int countMenu = menuDao.countMenu(menuInfo);
        if (0 != countMenu){
            return AppResponse.bizError("菜单已存在");
        }
        menuInfo.setMenuCode(StringUtil.getCommonCode(2));
        menuInfo.setIsDelete(0);
        //新增菜单
        int count = menuDao.addMenu(menuInfo);
        if(0 == count) {
            return AppResponse.bizError("新增失败");
        }
        return AppResponse.success("新增成功");
    }
    /**
     * 查询菜单详情
     * @param menuCode
     * @return
     */
    public AppResponse findMenuByCode (String menuCode){
        MenuInfo menuInfo = menuDao.findMenuByCode(menuCode);
        return AppResponse.success("查询菜单成功",menuInfo);
    }

    /**
     * 修改菜单
     * @param menuInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateMenuByCode (MenuInfo menuInfo) {
        AppResponse appResponse = AppResponse.success("修改成功");
        //校验菜单是否存在
        int countMenu = menuDao.countMenu(menuInfo);
        if (0 != countMenu){
            return AppResponse.bizError("菜单已存在");
        }
        //修改菜单
        int count = menuDao.updateMenuByCode(menuInfo);
        if (0 == count) {
            return  AppResponse.versionError("数据有变化，请刷新！");
        }
        return appResponse;
    }

    /**
     * 查询菜单列表
     * @param userCode
     * @return
     */
    public AppResponse listMenu (String userCode) {
        //获取操作人的编号及角色
        UserInfo userInfo = menuDao.getUser(userCode);
        //管理员查全部菜单
        if (RoleUtil.ADMIN.equals(userInfo.getRole()) || RoleUtil.MANAGER.equals(userInfo.getRole())){
            List<MenuInfo> menuInfoList = menuDao.listMenu(userInfo.getRole());
            if (menuInfoList != null){
                return AppResponse.success("查询菜单列表成功!",menuInfoList);
            }
        }
        return AppResponse.bizError("权限不足，无法查看！");
    }

    /**
     * 删除菜单
     * @param menuCode
     * @param userId
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse deleteMenu (String menuCode, String userId) {
        AppResponse appResponse = AppResponse.success("删除成功！");
        //删除菜单
        int count = menuDao.deleteMenu(menuCode,userId);
        if (0 == count) {
            return AppResponse.bizError("删除菜单失败");
        }
        return appResponse;
    }
}
