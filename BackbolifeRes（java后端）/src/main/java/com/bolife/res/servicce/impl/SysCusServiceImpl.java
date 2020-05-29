package com.bolife.res.servicce.impl;

import com.bolife.res.entity.SysCus;
import com.bolife.res.mapper.SysCusMapper;
import com.bolife.res.servicce.SysCusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<SysCus> getAllSysCus() {
        return sysCusMapper.selectAllSysCus();
    }

    @Override
    public void insertCus(String cusid, String name) {
        SysCus sysCus = new SysCus();
        sysCus.setCusId(cusid);
        sysCus.setNickName(name);
        sysCus.setLimits("true");
        sysCusMapper.insert(sysCus);
    }

    @Override
    public void delete(String cusid) {
        sysCusMapper.delete(cusid);
    }
}
