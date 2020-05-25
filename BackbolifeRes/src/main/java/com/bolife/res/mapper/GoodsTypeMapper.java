package com.bolife.res.mapper;

import com.bolife.res.entity.GoodsType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 15:22
 * @Description:
 */
@Mapper
public interface GoodsTypeMapper {
    List<GoodsType> getAllGoodsType();
}
