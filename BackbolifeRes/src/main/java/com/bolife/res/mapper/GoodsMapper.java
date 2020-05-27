package com.bolife.res.mapper;

import com.bolife.res.entity.Goods;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 15:29
 * @Description:
 */
@Mapper
public interface GoodsMapper {
    List<Goods> getGoodsByGtId(@Param("gtId") String gtId);

    List<Goods> getAllGoods();

    void update(@Param("goods") Goods goods);

    void delete(@Param("goodId") String goodId);

    Goods getGoodById(@Param("goodId") String goodId);

    void insert(@Param("goods") Goods goods);
}
