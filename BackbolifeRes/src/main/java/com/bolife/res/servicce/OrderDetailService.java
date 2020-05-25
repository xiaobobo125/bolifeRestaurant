package com.bolife.res.servicce;

import com.bolife.res.entity.OrderDetail;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 14:19
 * @Description:
 */
public interface OrderDetailService {
    public List<OrderDetail> getOrderDetailByOId(String orderId);

}
