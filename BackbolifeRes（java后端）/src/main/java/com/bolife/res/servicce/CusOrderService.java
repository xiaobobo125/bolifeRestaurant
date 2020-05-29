package com.bolife.res.servicce;

import com.bolife.res.entity.CusOrders;
import com.bolife.res.entity.Customer;
import com.bolife.res.entity.Goods;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 11:53
 * @Description:
 */
public interface CusOrderService {

    public List<CusOrders> getOrderByCus(Customer customer);

    CusOrders saveOrder(List<Goods> goods, String cusid);

    List<CusOrders> getAllOrder();

    void deleteOrder(String orderid);

    CusOrders getORderByOrderId(String orderid);
}
