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

    @Override
    public List<Goods> getAllGoods() {
        return goodsMapper.getAllGoods();
    }

    @Override
    public void update(Goods goods) {
        goodsMapper.update(goods);
    }

    @Override
    public void delete(String goodId) {
        goodsMapper.delete(goodId);
    }

    @Override
    public Goods getGoodsById(String goodId) {
        return goodsMapper.getGoodById(goodId);
    }

    @Override
    public void insert(Goods goods) {
        goodsMapper.insert(goods);
    }
}
