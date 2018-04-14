package com.demo.movie.controller;

import com.demo.movie.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate rest;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/get_movie/{user_id}")
    public User findById(@PathVariable  Integer user_id) {
        ServiceInstance instance = loadBalancerClient.choose("user");
        System.out.println(instance.getHost() + ":" + instance.getPort()+ ":" + instance.getServiceId());

        return rest.getForObject("http://user/get_user/" + user_id, User.class);
//        u.setAge(u.getAge()+"岁");
//        return u;
    }

    @GetMapping("/test")
    public String test(){
        ServiceInstance instance = loadBalancerClient.choose("user");
        System.out.println(instance.getHost() + ":" + instance.getPort()+ ":" + instance.getServiceId());

        ServiceInstance instance1 = loadBalancerClient.choose("user1");
        System.out.println(instance1.getHost() + ":" + instance1.getPort()+ ":" + instance1.getServiceId());

        ServiceInstance instance2 = loadBalancerClient.choose("user2");
        System.out.println(instance2.getHost() + ":" + instance2.getPort()+ ":" + instance2.getServiceId());
        return "1";
    }
}
