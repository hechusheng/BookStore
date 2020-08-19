package com.xzsd.pc.menu.dao;

import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.user.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**
 * @ClassName MenuDao
 * @Description 菜单管理
 * @Author hechusheng
 * @Date 2020-4-10
 */
@Mapper
public interface MenuDao {
    /**
     * 统计菜单数量
     * @param menuInfo
     * @return
     */
    int countMenu (MenuInfo menuInfo);
    /**
     * 新增菜单
     * @param menuInfo
     * @return
     */
    int addMenu (MenuInfo menuInfo);
    /**
     * 查询菜单详情
     * @param menuCode
     * @return
     */
    MenuInfo findMenuByCode(@Param("menuCode")String menuCode);
    /**
     *修改菜单
     * @param menuInfo
     * @return
     */
    int updateMenuByCode (MenuInfo menuInfo);

    /**
     * 查询菜单列表
     * @return
     */
    List<MenuInfo> listMenu (@Param("role") String role);

    /**
     * 删除菜单
     * @param menuCode
     * @param userId
     * @return
     */
    int deleteMenu (@Param("menuCode")String menuCode,@Param("userId")String userId);

    /**
     * 查询操作人角色
     * @param userCode
     * @return
     */
    UserInfo getUser (@Param("userCode") String userCode);
}
