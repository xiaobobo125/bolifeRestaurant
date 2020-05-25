package com.bolife.res.servicce.impl;

import com.bolife.res.entity.CusOrders;
import com.bolife.res.entity.Customer;
import com.bolife.res.mapper.CusOrderMapper;
import com.bolife.res.servicce.CusOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
