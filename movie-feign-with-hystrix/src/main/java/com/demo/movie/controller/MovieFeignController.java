package com.demo.movie.controller;

import com.demo.movie.client.UserFeignClient;
import com.demo.movie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieFeignController {

    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/get_movie_feign/{user_id}")
    public User findById(@PathVariable  Integer user_id) {
        return userFeignClient.findById(user_id);
    }

}
