package com.bolife.res.entity;

import lombok.Data;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 11:48
 * @Description:
 */
@Data
public class CusOrders {
    private String orderId;
    private String cusId;
    private Integer orderTime;
    private Integer orderState;
    private Double orderTotalPrice;
    private Integer orderNum;

    private Integer orderSort;
}
