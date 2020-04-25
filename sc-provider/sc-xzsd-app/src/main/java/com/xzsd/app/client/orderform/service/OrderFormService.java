package com.xzsd.app.client.orderform.service;


import com.xzsd.app.client.orderform.dao.OrderFormDao;
import com.xzsd.app.client.orderform.entity.OrderAssess;
import com.xzsd.app.client.orderform.entity.OrderDetail;
import com.xzsd.app.client.orderform.entity.OrderInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.RoleUtil;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

@Service
public class OrderFormService {
    @Resource
    private OrderFormDao orderFormDao;

    /**
     * 查询订单列表
     * @param orderInfo
     * @return
     */
    public AppResponse listOrderByPage(OrderInfo orderInfo){
        List<OrderDetail> orderDetailList = orderFormDao.listOrderByPage(orderInfo);
        for (int i = 0 ; i <orderDetailList.size() ; i++ ){
            orderDetailList.get(i).setTotalCmd(orderDetailList.get(i).getCmdInfoList().size());
        }
        return AppResponse.success("查询订单列表成功",getPageInfo(orderDetailList));
    }

    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
    public AppResponse getOrder(String orderCode){
        OrderDetail orderDetail = orderFormDao.getOrder(orderCode);
        return AppResponse.success("查询订单详情成功！",orderDetail);
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderStatus(OrderInfo orderInfo){
        int result = orderFormDao.updateOrderStatus(orderInfo);
        if (0 == result){
            return AppResponse.bizError("修改订单状态失败!");
        }
        return AppResponse.success("修改订单状态成功!");
    }

    /**
     * 新增评价
     * @param orderAssess
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addCommodityAssess (OrderAssess orderAssess) {
        //查询订单状态
        OrderInfo orderInfo = orderFormDao.getOrderStatus(orderAssess.getOrderCode());
        String os =orderInfo.getOrderStatus();
        System.out.println("订单状态："+os);
        if(!os.equals(RoleUtil.SUCCESS_VALUE)) {
            return AppResponse.bizError("订单未完成或已评价");
        }
        String userCode = orderAssess.getUserCode();
        System.out.println("userCode"+userCode);
        //循环设置评价信息
        for (int i = 0 ; i < orderAssess.getAssessInfoList().size() ; i ++){
            //设置评价信息
            orderAssess.getAssessInfoList().get(i).setAssessCode(StringUtil.getCommonCode(2));
            orderAssess.getAssessInfoList().get(i).setCreateUser(userCode);
            orderAssess.getAssessInfoList().get(i).setIsDelete(0);
        }
        //更新商品评价星级
        int countStar = orderFormDao.updateStarLevel(orderAssess.getAssessInfoList());
        if ( 0 == countStar){
            return AppResponse.bizError("修改商品星级失败！");
        }
        //新增评价
        int count = orderFormDao.addCommodityAssess(orderAssess);
        if (orderAssess.getAssessInfoList().size() != count) {
            return AppResponse.bizError("评价失败！");
        }
        //设置订单状态为已评价
        OrderInfo order = new OrderInfo(orderAssess.getOrderCode(),RoleUtil.EVALUETED_VALUE,orderAssess.getUpdateUser());
        order.setVersion(orderInfo.getVersion());
        int updateStatus = orderFormDao.updateOrderStatus(order);
        if (0 == updateStatus){
            return AppResponse.bizError("评价失败！请稍后重试！");
        }
        return AppResponse.success("评价成功！");
    }

}
