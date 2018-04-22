package com.demo.movie.client;

import com.demo.movie.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "user")
public interface UserFeignClient {

    @GetMapping("/get_user/{user_id}")
//    @RequestMapping(method = RequestMethod.GET, value = "/get_user/{user_id}")
    User findById(@PathVariable("user_id") Integer user_id);
//    User findById(Integer user_id);

//    @RequestMapping(method = RequestMethod.POST, value = "/post_user")
    @PostMapping("/post_user")
    User postUser(@RequestBody User u);

//    @RequestMapping(method = RequestMethod.GET, value = "/stores")
//    List<Store> getStores();
//
//    @RequestMapping(method = RequestMethod.POST, value = "/stores/{storeId}", consumes = "application/json")
//    Store update(@PathVariable("storeId") Long storeId, Store store);
}