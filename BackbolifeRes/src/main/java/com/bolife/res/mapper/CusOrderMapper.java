package com.bolife.res.mapper;

import com.bolife.res.entity.CusOrders;
import com.bolife.res.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 11:54
 * @Description:
 */
@Mapper
public interface CusOrderMapper {
    List<CusOrders> getOrderByCus(@Param("customer") Customer customer);

    void insert(CusOrders cusOrders);

    List<CusOrders> getAllOrder();

    void deleteOrder(@Param("orderId") String orderid);

    CusOrders getOrderByOrder(@Param("orderId") String orderid);
}
