package com.demo.user.controller;

import com.demo.user.bean.User;
import com.demo.user.repository.UserRepository;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private EurekaClient eurekaClient;

    @Autowired
    private DiscoveryClient discoveryClient;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/get_user/{user_id}")
    public User findById(@PathVariable Integer user_id){
        return userRepository.findOne(user_id);
    }

    @PostMapping("/post_user")
    public User postUser(@RequestBody User u){
        return u;
    }

    @GetMapping("/eureka_instance")
    public String serviceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("USER", false);
        return instance.getHomePageUrl();
    }

    @GetMapping("/instance_info")
    public ServiceInstance showInfo() {
        return discoveryClient.getLocalServiceInstance();
    }
}
