package com.xzsd.app.client.orderform.service;


import com.xzsd.app.client.addOrder.entity.OrderDetails;
import com.xzsd.app.client.orderform.dao.OrderFormDao;
import com.xzsd.app.client.orderform.entity.CmdInfo;
import com.xzsd.app.client.orderform.entity.OrderAssess;
import com.xzsd.app.client.orderform.entity.OrderDetail;
import com.xzsd.app.client.orderform.entity.OrderInfo;
import com.xzsd.app.util.AppResponse;
import com.xzsd.app.util.RoleUtil;
import com.xzsd.app.util.StringUtil;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @ClassName  ManagerOrder
 * @Description 客户端订单信息实现层
 * @Author hechusheng
 * @Date 2020-04-24
 */
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
        //修改订单状态
        int result = orderFormDao.updateOrderStatus(orderInfo);
        if (0 == result){
            return AppResponse.bizError("修改订单状态失败!");
        }
        System.out.println("订单状态"+orderInfo.getOrderStatus());
        //若订单状态为取消，则修改该商品的库存
        if (RoleUtil.CANCEL_VALUE.equals(orderInfo.getOrderStatus())){
            //获取订单详情
            OrderDetail orderDetail =  orderFormDao.getOrder(orderInfo.getOrderCode());
            //获取订单的商品信息列表
            List<CmdInfo> cmdInfoList = orderDetail.getCmdInfoList();
            //新建购买数量列表
            List<OrderDetail> orderDetailList = new ArrayList<>();
            for (int i = 0; i < cmdInfoList.size(); i++) {
                OrderDetail order = new OrderDetail();
                order.setComCode(cmdInfoList.get(i).getComCode());
                order.setComCount(cmdInfoList.get(i).getComCount());
                orderDetailList.add(order);
            }
            int count = orderFormDao.updateCmd(orderDetailList);
            if (0 == count){
                return AppResponse.bizError("修改订单状态失败,商品库存失败!");
            }
        }
        //若订单状态为已完成，则修改该商品的销量
        if (RoleUtil.SUCCESS_VALUE.equals(orderInfo.getOrderStatus())){
            //获取订单详情
            OrderDetail orderDetail1 =  orderFormDao.getOrder(orderInfo.getOrderCode());
            //获取订单的商品信息列表
            List<CmdInfo> cmdInfoList1 = orderDetail1.getCmdInfoList();
            //新建购买数量列表
            List<OrderDetail> orderDetailList1 = new ArrayList<>();
            //传入购买的商品编号及数量
            for (int i = 0; i < cmdInfoList1.size(); i++) {
                OrderDetail od = new OrderDetail();
                od.setComCode(cmdInfoList1.get(i).getComCode());
                od.setComCount(cmdInfoList1.get(i).getComCount());
                orderDetailList1.add(od);
            }
            //更新商品销量
            int countOd = orderFormDao.updateCmdSale(orderDetailList1);
            if (0 == countOd){
                return AppResponse.bizError("修改订单状态失败,商品销量修改失败!");
            }
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
        //检验订单是否完成或已评价
        if(!os.equals(RoleUtil.SUCCESS_VALUE)) {
            return AppResponse.bizError("订单未完成或已评价");
        }
        String userCode = orderAssess.getUserCode();
        //设置评价信息
        for (int i = 0 ; i < orderAssess.getAssessInfoList().size() ; i ++){
            orderAssess.getAssessInfoList().get(i).setAssessCode(StringUtil.getCommonCode(2));
            orderAssess.getAssessInfoList().get(i).setCreateUser(userCode);
            orderAssess.getAssessInfoList().get(i).setIsDelete(0);
        }
        //新增评价
        int count = orderFormDao.addCommodityAssess(orderAssess);
        if (orderAssess.getAssessInfoList().size() != count) {
            return AppResponse.bizError("评价失败！");
        }
        System.out.println("这是评价前的状态"+orderInfo.getOrderStatus());
        //设置订单状态为已评价
        OrderInfo order = new OrderInfo(orderAssess.getOrderCode(),RoleUtil.EVALUETED_VALUE,orderAssess.getUpdateUser());
        order.setVersion(orderInfo.getVersion());
        int updateStatus = orderFormDao.updateOrderStatus(order);
        if (0 == updateStatus){
            return AppResponse.bizError("评价失败！请稍后重试！");
        }
        //重新查询订单状态
        OrderInfo orderInfo1 = orderFormDao.getOrderStatus(orderAssess.getOrderCode());
        System.out.println("这是评价后的状态"+orderInfo1.getOrderStatus());
        //若订单状态为已评价,则将购买商品的星级更新
        if (RoleUtil.EVALUETED_VALUE.equals(orderInfo1.getOrderStatus())){
            //更新商品评价星级
            int countStar = orderFormDao.updateStarLevel(orderAssess.getAssessInfoList());
            if ( 0 == countStar){
                return AppResponse.bizError("修改商品星级失败！");
            }
        }
        return AppResponse.success("评价成功！");
    }

}
