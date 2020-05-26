package com.bolife.res.servicce;

import com.bolife.res.entity.SysCus;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 12:06
 * @Description:
 */
public interface SysCusService {
    public SysCus getSysCusById(String CusId);

    List<SysCus> getAllSysCus();

    void insertCus(String cusid, String name);

    void delete(String cusid);
}
