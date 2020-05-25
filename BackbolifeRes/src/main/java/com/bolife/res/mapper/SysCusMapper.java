package com.bolife.res.mapper;

import com.bolife.res.entity.SysCus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 12:08
 * @Description:
 */
@Mapper
public interface SysCusMapper {
    public SysCus selectSysCusById(@Param("cusId")String cusId);
}
