package com.bolife.res.mapper;

import com.bolife.res.entity.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 10:56
 * @Description:
 */
@Mapper
public interface CustomerMapper {

    public List<Customer> findAllCustomer();

    Customer getCustomer(@Param("customer") Customer customer);

    void insertCustomer(@Param("customer") Customer customer);
}
