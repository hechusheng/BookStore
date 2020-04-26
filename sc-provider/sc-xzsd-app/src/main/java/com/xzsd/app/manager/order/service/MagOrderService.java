package com.xzsd.app.manager.order.service;

import com.xzsd.app.manager.order.dao.MagOrderDao;
import com.xzsd.app.manager.order.entity.ManageOrder;
import com.xzsd.app.manager.order.entity.OrderDetail;
import com.xzsd.app.manager.order.entity.OrderInfo;
import com.xzsd.app.util.AppResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
import java.util.List;

import static com.neusoft.core.page.PageUtils.getPageInfo;

/**
 * @ClassName  MagOrderService
 * @Description 店长端订单信息控制层
 * @Author hechusheng
 * @Date 2020-04-25
 */
@Service
public class MagOrderService {
    @Resource
    private MagOrderDao magOrderDao;

    /**
     * 查询订单列表
     * @param manageOrder
     * @return
     */
    public AppResponse listOrderByPage(ManageOrder manageOrder){
        //获取门店编号
        String storeCode = magOrderDao.getStoreMessage(manageOrder.getUserCode()).getStoreCode();
        manageOrder.setStoreCode(storeCode);
        List<OrderDetail> orderDetailList = magOrderDao.listOrderByPage(manageOrder);
        return AppResponse.success("查询订单列表成功",getPageInfo(orderDetailList));
    }

    /**
     * 查询订单详情
     * @param orderCode
     * @return
     */
    public AppResponse getOrder(String orderCode){
        OrderDetail orderDetail = magOrderDao.getOrder(orderCode);
        return AppResponse.success("查询订单详情成功！",orderDetail);
    }

    /**
     * 修改订单状态
     * @param orderInfo
     * @return
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderStatus(OrderInfo orderInfo){
        int count = magOrderDao.updateOrderStatus(orderInfo);
        if (0 == count){
            return AppResponse.bizError("修改订单状态失败!");
        }
        return AppResponse.success("修改订单状态成功!");
    }
}
