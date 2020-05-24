package com.bolife.res.entity;

import lombok.Data;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/24 16:07
 * @Description:
 */
@Data
public class OverOrder {
    private String orderId;
    private String cusId;
    private Integer orderTime;
    private Integer orderState;
    private Double orderTotlePrice;
    private Integer orderNum;

    private Customer customer;
}
