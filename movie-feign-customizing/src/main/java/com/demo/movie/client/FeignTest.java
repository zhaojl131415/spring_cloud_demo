package com.demo.movie.client;

import com.demo.config.TestConfiguration;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "xxxx", url = "http://localhost:8761/", configuration = TestConfiguration.class)
public interface FeignTest {

    @RequestMapping(path = "/eureka/apps/{serviceName}")
    String findServiceInfoFromEurekaByServiceName(@PathVariable("serviceName") String serviceName);
}
