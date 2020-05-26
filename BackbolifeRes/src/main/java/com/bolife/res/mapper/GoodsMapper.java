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
}
