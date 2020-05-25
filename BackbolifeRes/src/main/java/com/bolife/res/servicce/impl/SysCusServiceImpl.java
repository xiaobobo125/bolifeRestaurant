package com.bolife.res.servicce.impl;

import com.bolife.res.entity.SysCus;
import com.bolife.res.mapper.SysCusMapper;
import com.bolife.res.servicce.SysCusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 12:07
 * @Description:
 */
@Service
public class SysCusServiceImpl implements SysCusService{
    @Autowired(required = false)
    private SysCusMapper sysCusMapper;
    @Override
    public SysCus getSysCusById(String cusId) {
        return sysCusMapper.selectSysCusById(cusId);
    }
}
