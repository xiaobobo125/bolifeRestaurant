package com.bolife.res.mapper;

import com.bolife.res.entity.SysCus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 12:08
 * @Description:
 */
@Mapper
public interface SysCusMapper {
    public SysCus selectSysCusById(@Param("cusId")String cusId);

    List<SysCus> selectAllSysCus();

    void insert(@Param("sysCus") SysCus sysCus);

    void delete(@Param("cusid") String cusid);
}
