package org.example.spl;

import org.example.spl.controller.CustomerController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

public class Main {

    public static void main(String[] args) {
        Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
        log.info("starting project...");

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        CustomerController customerController = (CustomerController) context.getBean("customerController");
        Customer customer = (Customer) context.getBean("customerBean");
        System.out.println(customerController.customerLogin(customer));

//        ValueOperations<String, Object> str = redisTemplate.opsForValue();
//        str.set("name", "Swift");
//        str.set("password", "123456");
//        System.out.println((String) str.get("password"));

//        Customer customer = (Customer) context.getBean("customerBean");
//        customer.displayInfo();
//
//        customer.getExtraInfo(1.83f, 77.0f);
//        customer.provideBasicInfo();

//        RedisUserService userService = context.getBean(RedisUserService.class);
//        String key = "name";
//        String value = userService.getString(key);
//        System.out.println(value);


        ((ClassPathXmlApplicationContext) context).close();

    }
}
