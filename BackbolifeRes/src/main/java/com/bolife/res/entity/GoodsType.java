package com.bolife.res.entity;

import lombok.Data;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/24 15:56
 * @Description:
 */
@Data
public class GoodsType {
    private String gtId;
    private String gtName;
    private Integer gtState;

    private List<Goods> goods;
}
