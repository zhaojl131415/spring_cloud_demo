package com.demo.movie.client;

import com.demo.movie.entity.User;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class HystrixClientFallback implements UserFeignClient {
    @Override
    public User findById(Integer user_id) {
        User u = new User();
        u.setId(0);
        return u;
    }
}