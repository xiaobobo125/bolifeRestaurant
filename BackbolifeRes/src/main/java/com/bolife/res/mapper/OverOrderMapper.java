package com.bolife.res.mapper;

import com.bolife.res.entity.OverOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 13:38
 * @Description:
 */
@Mapper
public interface OverOrderMapper {
    public List<OverOrder> getOverOrderByCusId(@Param("cusId") String cusId);

}
