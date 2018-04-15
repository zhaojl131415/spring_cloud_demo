package com.demo.movie.client;

import com.demo.config.FooConfiguration;
import com.demo.movie.entity.User;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;

@FeignClient(value = "user", configuration = FooConfiguration.class)
public interface UserFeignClient {
    @RequestLine("GET /get_user/{user_id}")
    User findById(@Param("user_id") Integer user_id);
}