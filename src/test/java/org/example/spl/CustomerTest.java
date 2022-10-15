package org.example.spl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerTest {

    @Before
    public void beforeAllTestMethods() {
        System.out.println("before testing all methods, do something...");
    }
    @Autowired
    Customer customer;

    @Test
    public void test() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Customer customer = (Customer) context.getBean("customerBean");
        System.out.println(customer.getBasicInfo());
    }
}
