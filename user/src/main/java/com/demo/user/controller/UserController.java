package com.demo.user.controller;

import com.demo.user.bean.User;
import com.demo.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/get_user/{user_id}")
    public User findById(@PathVariable Integer user_id){
        return userRepository.findOne(user_id);
    }
}
