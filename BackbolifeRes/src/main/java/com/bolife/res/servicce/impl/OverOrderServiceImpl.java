package com.bolife.res.servicce.impl;

import com.bolife.res.entity.OverOrder;
import com.bolife.res.mapper.OverOrderMapper;
import com.bolife.res.servicce.OverOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 13:38
 * @Description:
 */
@Service
public class OverOrderServiceImpl implements OverOrderService {
    @Autowired(required = false)
    private OverOrderMapper overOrderMapper;

    @Override
    public List<OverOrder> getOverOrderByCusId(String cusId) {
        return overOrderMapper.getOverOrderByCusId(cusId);
    }
}
