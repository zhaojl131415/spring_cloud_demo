package com.demo.movie;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class MovieApplication {

	@Bean
	public RestTemplate rest(){
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieApplication.class, args);
	}
}
