//package com.hotel.auth.services;
//
//import com.hotel.auth.dto.CredentialsDto;
//import com.hotel.auth.dto.UserDto;
//import com.hotel.auth.entity.User;
//import com.hotel.auth.exceptions.AppException;
//import com.hotel.auth.mappers.UserMapper;
//import com.hotel.auth.repository.UserRepository;
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.http.HttpStatus;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import javax.annotation.PostConstruct;
//import java.nio.CharBuffer;
//import java.util.Base64;
//import java.util.Date;
//import java.util.Optional;
//
//@Service
//public class UserService {
//
//    @Autowired
//    private UserRepository userRepository;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Autowired
//    private UserMapper userMapper;
//
//    @Autowired
//    private RestTemplate restTemplate;
//
//    @Value("${security.jwt.token.secret-key:secret-key}")
//    private String secretKey;
//
//
//    @PostConstruct
//    protected void init() {
//        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
//    }
//
//    public UserDto login(CredentialsDto credentialsDto) {
//        var user = userRepository.findByUsernameAndRole(credentialsDto.getEmail(), credentialsDto.getRole())
//                .orElseThrow(() -> new AppException("User not found", HttpStatus.NOT_FOUND));
//        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
//            return userMapper.toUserDto(user, createToken(user));
//        }
//        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
//    }
//
//    private String createToken(User user) {
//        Claims claims = Jwts.claims().setSubject(user.getUsername());
//
//        Date now = new Date();
//        Date validity = new Date(now.getTime() + 7200000); 
//
//        return Jwts.builder()
//                .setClaims(claims)
//                .setIssuedAt(now)
//                .setExpiration(validity)
//                .signWith(SignatureAlgorithm.HS256, secretKey)
//                .compact();
//    }
//
//    public boolean loginForAdmin(CredentialsDto credentialsDto) {
//        if (credentialsDto.getEmail() != null && credentialsDto.getPassword() != null) {
//            if (credentialsDto.getEmail().equals("dineshparsam@gmail.com") && credentialsDto.getPassword().equals(
//                    "chinna")) {
//                System.out.println("Welcome Owner!");
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public UserDto validateToken(String token) {
//        String login = Jwts.parser()
//                .setSigningKey(secretKey)
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//        Optional<User> userOptional = userRepository.findByUsername(login);
//
//        if (userOptional.isEmpty()) {
//            throw new AppException("User not found", HttpStatus.NOT_FOUND);
//        }
//
//        User user = userOptional.get();
//        return userMapper.toUserDto(user, createToken(user));
//    }
//
//    public UserDto createUser(CredentialsDto credentialsDto) {
//        User user = new User(credentialsDto.getEmail(), passwordEncoder.encode(credentialsDto.getPassword()),
//                credentialsDto.getRole());
//        try {
////        	UserDto userDto;
////			UserMapper userMapper= new UserMapper(userDto.getUsername(),ownerDto.getPassword());
//            return userMapper.toUserDto(userRepository.save(user), "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJkaW5lc2hwYXJzYW1AZ21haWwuY29tIiwiaWF0IjoxNjIzOTc5ODYyLCJleHAiOjE2MjM5ODcwNjJ9.EKmWMxyiTUVUwv08O37-kwms5EEfmFW56dmfn4Mi7fs");
//        } catch (Exception e) {
//            throw new AppException("User not saved", HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//
//    }
//
//    public UserDto updateUser(String username, CredentialsDto credentialsDto) {
//
//        Optional<User> optionalUser = userRepository.findByUsername(username);
//
//        if (optionalUser.isPresent()) {
//            User existingUser = optionalUser.get();
//            existingUser.setUsername(credentialsDto.getEmail());
//            existingUser.setPassword(passwordEncoder.encode(credentialsDto.getPassword()));
//            try {
//                return userMapper.toUserDto(userRepository.save(existingUser), "");
//            } catch (Exception e) {
//                throw new AppException("User not saved", HttpStatus.INTERNAL_SERVER_ERROR);
//            }
//        } else {
//            throw new AppException("User not found", HttpStatus.NOT_FOUND);
//
//        }
//    }
//}
