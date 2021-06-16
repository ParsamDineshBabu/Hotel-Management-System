package com.hotel.auth.controller;

import com.hotel.auth.dto.CredentialsDto;
import com.hotel.auth.dto.UserDto;
import com.hotel.auth.services.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@Slf4j
@RequestMapping("/auth")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signIn")
    public ResponseEntity<UserDto> signIn(@RequestBody CredentialsDto credentialsDto) {
        //log.info("Trying to login {}", credentialsDto.getEmail());
        return ResponseEntity.ok(userService.signIn(credentialsDto));
    }

    @PostMapping("/validateToken")
    public ResponseEntity<UserDto> signIn(@RequestParam String token) {
        //log.info("Trying to validate token {}", token);
        return ResponseEntity.ok(userService.validateToken(token));
    }

    @GetMapping("/test")
    public String test(){
        return "success";
    }

    @PostMapping("/createUser")
    public ResponseEntity<UserDto> createUser(@RequestBody CredentialsDto credentialsDto){
        return ResponseEntity.ok(userService.createUser(credentialsDto));
    }
    @PutMapping("/updateUser/{email}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String email ,@RequestBody CredentialsDto credentialsDto){
        return ResponseEntity.ok(userService.updateUser(email,credentialsDto));
    }
}
