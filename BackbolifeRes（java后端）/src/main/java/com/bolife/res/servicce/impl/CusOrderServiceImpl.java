package com.bolife.res.servicce.impl;

import com.bolife.res.entity.CusOrders;
import com.bolife.res.entity.Customer;
import com.bolife.res.entity.Goods;
import com.bolife.res.mapper.CusOrderMapper;
import com.bolife.res.servicce.CusOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 11:54
 * @Description:
 */
@Service
public class CusOrderServiceImpl implements CusOrderService {
    @Autowired(required = false)
    private CusOrderMapper cusOrderMapper;
    @Override
    public List<CusOrders> getOrderByCus(Customer customer) {
        return cusOrderMapper.getOrderByCus(customer);
    }

    @Override
    public CusOrders saveOrder(List<Goods> goods, String cusid) {
        CusOrders cusOrders = new CusOrders();
        cusOrders.setCusId(cusid);
        cusOrders.setOrderId(UUID.randomUUID().toString());
        Integer orderTime = 0;
        Double orderTotalPrice = 0.0d;
        for (Goods good : goods) {
            orderTime+=good.getGTime();
            orderTotalPrice+=good.getGPrice()*good.getGCount();
        }
        cusOrders.setOrderTime(orderTime);
        cusOrders.setOrderState(1);
        cusOrders.setOrderTotalPrice(orderTotalPrice);
        cusOrderMapper.insert(cusOrders);
        return cusOrders;
    }

    @Override
    public List<CusOrders> getAllOrder() {
        return cusOrderMapper.getAllOrder();
    }

    @Override
    public void deleteOrder(String orderid) {
        cusOrderMapper.deleteOrder(orderid);
    }

    @Override
    public CusOrders getORderByOrderId(String orderid) {
       return cusOrderMapper.getOrderByOrder(orderid);
    }
}
