package com.demo.movie.client;

import com.demo.movie.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user", fallback = HystrixClientFallback.class)
public interface UserFeignClient {

    @GetMapping("/get_user/{user_id}")
//    @RequestMapping(method = RequestMethod.GET, value = "/get_user/{user_id}")
    User findById(@PathVariable("user_id") Integer user_id);

}

