package com.hotel.auth;

import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.client.RestTemplate;

import com.hotel.auth.entity.User;
import com.hotel.auth.enums.ClientType;
import com.hotel.auth.repository.UserRepository;

@SpringBootApplication
@EnableEurekaClient
public class AuthenticationApplication {
	public static void main(String[] args) {
		SpringApplication.run(AuthenticationApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(){
		return  new RestTemplate();
	}
	@Bean
	public CommandLineRunner createAdmin(UserRepository userRepository,PasswordEncoder passwordEncoder){
		return args -> {
			Optional<User> optionalUser = userRepository.findByUsername("admin@admin.com");
			if(!optionalUser.isPresent()){
					saveAdmin(passwordEncoder,userRepository);
			}
		};
	}

	private void saveAdmin(PasswordEncoder passwordEncoder,UserRepository userRepository) {
		User admin = new User();
		admin.setUsername("admin@admin.com");
		admin.setPassword(passwordEncoder.encode("administrator"));
		admin.setRole(ClientType.Administrator.toString());
		userRepository.save(admin);
	}


}
