package com.demo.movie.controller;

import com.demo.movie.client.FeignTest;
import com.demo.movie.client.UserFeignClient;
import com.demo.movie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieFeignCustomizingController {

    @Autowired
    private UserFeignClient userFeignClient;
    @Autowired
    private FeignTest feignTest;

    @GetMapping("/get_movie_feign_customizing/{user_id}")
    public User findById(@PathVariable Integer user_id) {
        return userFeignClient.findById(user_id);
    }

    @GetMapping("/{serviceName}")
    public String findById(@PathVariable String serviceName) {
        return feignTest.findServiceInfoFromEurekaByServiceName(serviceName);
    }

}
