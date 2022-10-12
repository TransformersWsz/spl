package org.example.spl.service.impl;

import org.example.spl.Customer;
import org.example.spl.dao.CustomerDao;
import org.example.spl.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    CustomerDao customerDao;


    @Override
    public boolean customerLogin(Customer customer) {
        System.out.println(customer.getBasicInfo());
        Customer redisCustomer = customerDao.customerLogin(customer);
        System.out.println(redisCustomer.getBasicInfo());
        if (redisCustomer.getUsername() != null && redisCustomer.getUsername().equals(customer.getUsername())
            && redisCustomer.getPassword() != null && redisCustomer.getPassword().equals(customer.getPassword())) {
            return true;
        }
        return false;
    }
}