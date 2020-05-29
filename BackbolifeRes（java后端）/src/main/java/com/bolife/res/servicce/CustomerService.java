package com.bolife.res.servicce;

import com.bolife.res.entity.Customer;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 10:55
 * @Description:
 */
public interface CustomerService {

    public List<Customer> listCustomer();

    public Customer getCustomer(Customer customer);

    public void regCustomer(Customer customer);
}
