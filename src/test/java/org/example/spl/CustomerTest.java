package org.example.spl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class CustomerTest {

    @Autowired
    Customer customer;

    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Before
    public void beforeAllTestMethods() {
        System.out.println("before testing all methods, do something...");
    }

    @Test
    public void test() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        Customer customer = (Customer) context.getBean("customerBean");
        System.out.println(customer.provideBasicInfo());
    }

    @Test
    public void serializeObj() {
        ObjectMapper objectMapper = new ObjectMapper();
        Customer c = new Customer();
        c.setUsername("asd");
        c.setPassword("sdf");
        try {
            String s = objectMapper.writeValueAsString(c);
            this.redisTemplate.opsForValue().set("obj", s);
            System.out.println("serialize success!!!");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            System.out.println("serialize failure!!!");
        }
    }

    @Test
    public void deserializeObj() {
        ObjectMapper objectMapper = new ObjectMapper();
        String s = (String) this.redisTemplate.opsForValue().get("obj");

        try {
            Customer c = objectMapper.readValue(s, Customer.class);
            System.out.println(c.provideBasicInfo());
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }

}
