package com.demo.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
//@EnableEurekaClient
//@EnableCircuitBreaker
@SpringCloudApplication
public class MovieRibbonWithHystrixApplication {

	@Bean
	@LoadBalanced
	public RestTemplate rest(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieRibbonWithHystrixApplication.class, args);
	}
}
