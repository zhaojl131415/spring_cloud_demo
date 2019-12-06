package com.demo.movie.client;

import com.demo.movie.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserHystrixClientFallback implements UserFeignClient {
    @Override
    public User findById(Integer user_id) {
        return new User();
    }
}