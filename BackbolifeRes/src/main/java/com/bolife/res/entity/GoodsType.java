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
    private String gTid;
    private String gTName;
    private Integer gState;

    private List<Goods> goods;
}
