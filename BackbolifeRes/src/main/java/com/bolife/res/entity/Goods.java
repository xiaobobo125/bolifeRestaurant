package com.bolife.res.entity;

import lombok.Data;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/24 15:55
 * @Description:
 */
@Data
public class Goods {
    private String gId;
    private String gtId;
    private String gName;
    private Double gPrice;
    private String gContent;
    private String gImg;
    private Integer gTime;
    private Integer gCount;
    private String gInfo;

    private GoodsType goodsType;
}