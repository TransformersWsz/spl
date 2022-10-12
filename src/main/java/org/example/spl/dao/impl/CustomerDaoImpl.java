package org.example.spl.dao.impl;

import org.example.spl.Customer;
import org.example.spl.dao.CustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDaoImpl implements CustomerDao {
    @Autowired
    RedisTemplate<String, Object> redisTemplate;

    @Override
    public Customer customerLogin(Customer customer) {
        ValueOperations<String, Object> ops = redisTemplate.opsForValue();
        String username = (String) ops.get("name");
        String password = (String) ops.get("password");
        return new Customer(username, password);
    }
}
