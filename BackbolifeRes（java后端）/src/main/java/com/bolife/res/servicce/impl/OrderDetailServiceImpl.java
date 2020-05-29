package com.bolife.res.servicce.impl;

import com.bolife.res.entity.CusOrders;
import com.bolife.res.entity.Goods;
import com.bolife.res.entity.OrderDetail;
import com.bolife.res.mapper.OrderDetailMapper;
import com.bolife.res.servicce.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 14:20
 * @Description:
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired(required = false)
    private OrderDetailMapper orderDetailMapper;
    @Override
    public List<OrderDetail> getOrderDetailByOId(String orderId) {
        return orderDetailMapper.getOrderDetailByOId(orderId);
    }

    @Override
    public void save(List<Goods> goods, CusOrders cusOrders) {
        OrderDetail orderDetail = new OrderDetail();
        for (Goods good : goods) {
            orderDetail.setGId(good.getGId());
            orderDetail.setGCount(good.getGCount().doubleValue());
            orderDetail.setGName(good.getGName());
            orderDetail.setGPrice(good.getGPrice().toString());
            orderDetail.setGTime(good.getGTime());
            orderDetail.setOrderId(cusOrders.getOrderId());
            orderDetailMapper.insert(orderDetail);
        }
    }
}
