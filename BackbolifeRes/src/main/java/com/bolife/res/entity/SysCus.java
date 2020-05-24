package com.bolife.res.entity;

import lombok.Data;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/24 16:11
 * @Description:
 */
@Data
public class SysCus {
    private String cusId;
    private String nickName;
    private String limits;
    private Customer customer;
}
