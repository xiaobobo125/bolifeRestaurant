package com.bolife.res.servicce;

import com.bolife.res.entity.OverOrder;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 13:37
 * @Description:
 */
public interface OverOrderService {

    public List<OverOrder> getOverOrderByCusId(String cusId);
}
