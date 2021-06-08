package com.hotel.MasterMicro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MasterMicroApplication {

	public static void main(String[] args) {
		SpringApplication.run(MasterMicroApplication.class, args);
	}
	
	 @Bean
	 @LoadBalanced
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	 
	/*
	 * @RequestMapping("/") public String test() { RestTemplate resttemplate = new
	 * RestTemplate();
	 * 
	 * String s = resttemplate.getForObject("http://localhost:8089", String.class);
	 * return s +"manojjjjj" ;
	 * 
	 * }
	 */


}
