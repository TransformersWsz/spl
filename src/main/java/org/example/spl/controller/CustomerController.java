package org.example.spl.controller;

import org.example.spl.Customer;
import org.example.spl.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {
    @Autowired
    CustomerService customerService;

    public String customerLogin(Customer customer) {
        boolean result = customerService.customerLogin(customer);
        if (result) {
            return "登录成功！";
        }
        return "用户名或密码错误！";
    }
}
