package com.bolife.res.servicce;

import com.bolife.res.entity.Goods;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 15:27
 * @Description:
 */
public interface GoodsService {
    public List<Goods> getGoodsByGtId(String gtId);

}
