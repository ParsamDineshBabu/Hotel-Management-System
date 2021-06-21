package com.hotel.FunctionMicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@CrossOrigin
@SpringBootApplication
@EnableEurekaClient
public class FunctionMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(FunctionMicroApplication.class, args);
	}
	
	 @Bean
	 @LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	 
	/*
	 * @RequestMapping("/test") public String test1() { RestTemplate resttemplate =
	 * new RestTemplate();
	 * 
	 * String s = resttemplate.getForObject("http://localhost:9191", String.class);
	 * return s +"Dinesh" ;
	 * 
	 * }
	 */
}
