package com.bolife.res.servicce.impl;

import com.bolife.res.entity.Goods;
import com.bolife.res.mapper.GoodsMapper;
import com.bolife.res.servicce.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 15:28
 * @Description:
 */
@Service
public class GoodsServiceImpl implements GoodsService{

    @Autowired(required = false)
    private GoodsMapper goodsMapper;

    @Override
    public List<Goods> getGoodsByGtId(String gtId) {
        return goodsMapper.getGoodsByGtId(gtId);
    }
}
