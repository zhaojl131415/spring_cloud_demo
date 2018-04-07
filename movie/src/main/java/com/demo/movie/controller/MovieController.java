package com.demo.movie.controller;

import com.demo.movie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate rest;

    @GetMapping("/get_movie/{user_id}")
    public User findById(@PathVariable  Integer user_id) {
        User u =  rest.getForObject("http://localhost:8091/get_user/" + user_id, User.class);
        u.setAge(u.getAge()+"岁");
        return u;
    }
}
