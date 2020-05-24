package com.bolife.res.entity;

import lombok.Data;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/24 16:01
 * @Description:
 */
@Data
public class OrderDetail {
    private String gId;
    private String orderId;
    private String gName;
    private Double gCount;
    private String gPrice;
    private Integer gTime;

    private Goods goods;
}
