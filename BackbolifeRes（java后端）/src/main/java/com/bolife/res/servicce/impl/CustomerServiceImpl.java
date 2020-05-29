package com.bolife.res.servicce.impl;

import com.bolife.res.entity.Customer;
import com.bolife.res.mapper.CustomerMapper;
import com.bolife.res.servicce.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Mr.BoBo
 * @Date: 2020/5/25 10:55
 * @Description:
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired(required = false)
    private CustomerMapper customerMapper;

    @Override
    public List<Customer> listCustomer() {
        return customerMapper.findAllCustomer();
    }

    @Override
    public Customer getCustomer(Customer customer) {
        return customerMapper.getCustomer(customer);
    }

    @Override
    public void regCustomer(Customer customer) {
        customerMapper.insertCustomer(customer);
    }
}
