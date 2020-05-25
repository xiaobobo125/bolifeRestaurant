package com.bolife.res.servicce.impl;

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
}
