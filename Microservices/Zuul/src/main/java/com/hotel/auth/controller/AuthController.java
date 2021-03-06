package com.hotel.auth.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.auth.entity.User;
import com.hotel.auth.payload.request.LoginRequest;
import com.hotel.auth.payload.request.SignupRequest;
import com.hotel.auth.payload.response.MessageResponse;
import com.hotel.auth.repository.UserRepository;


@CrossOrigin
@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	UserRepository userRepository;

	 @GetMapping(value = "/test/security")
	    public String security() {


	        return "security set up done!!";
	    }
	
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {

		 Optional<User> user = userRepository.findByUsername(loginRequest.getUsername());
	                
		
		return ResponseEntity.ok(user);
	}

	@PostMapping("/signup")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignupRequest signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Username is already taken!"));
		}

		if (userRepository.existsByEmpId(signUpRequest.getEmpId())) {
			return ResponseEntity
					.badRequest()
					.body(new MessageResponse("Error: Email is already in use!"));
		}

		// Create new user's account
		User user = new User(signUpRequest.getUsername(),
							 signUpRequest.getEmpId(),
							 signUpRequest.getPassword(),signUpRequest.getRole());

		userRepository.save(user);

		return ResponseEntity.ok(new MessageResponse("User registered successfully!"));
	}
}
