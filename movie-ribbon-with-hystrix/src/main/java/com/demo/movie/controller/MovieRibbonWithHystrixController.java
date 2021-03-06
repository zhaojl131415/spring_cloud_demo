package com.demo.movie.controller;

import com.demo.movie.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieRibbonWithHystrixController {

    @Autowired
    private RestTemplate rest;

    @GetMapping("/get_movie/{user_id}")
    @HystrixCommand(fallbackMethod = "findByIdFallback")
    public User findById(@PathVariable Integer user_id) {
        return rest.getForObject("http://user/get_user/{1}" + user_id, User.class, user_id);
    }

    // 回调方法 参数和返回值必须和原方法一样
    public User findByIdFallback(Integer user_id) {
        User u = new User();
        u.setId(0);
        return u;
    }

}
