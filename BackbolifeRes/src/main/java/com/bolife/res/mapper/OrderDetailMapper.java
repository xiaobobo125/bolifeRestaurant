package com.bolife.res.mapper;

import com.bolife.res.entity.OrderDetail;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 14:20
 * @Description:
 */
@Mapper
public interface OrderDetailMapper {
    List<OrderDetail> getOrderDetailByOId(@Param("orderId") String orderId);
}
