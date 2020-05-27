package com.bolife.res.servicce.impl;

import com.bolife.res.entity.GoodsType;
import com.bolife.res.mapper.GoodsTypeMapper;
import com.bolife.res.servicce.GoodsTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 15:22
 * @Description:
 */
@Service
public class GoodsTypeServiceImpl implements GoodsTypeService {

    @Autowired(required = false)
    private GoodsTypeMapper goodsTypeMapper;

    @Override
    public List<GoodsType> getAllGoodsType() {
        return goodsTypeMapper.getAllGoodsType();
    }

    @Override
    public void addType(String newtypename, String gtid) {
        GoodsType goodsType = new GoodsType();
        goodsType.setGtId(gtid);
        goodsType.setGtName(newtypename);
        goodsType.setGtState(1);
        goodsTypeMapper.insert(goodsType);
    }
}
