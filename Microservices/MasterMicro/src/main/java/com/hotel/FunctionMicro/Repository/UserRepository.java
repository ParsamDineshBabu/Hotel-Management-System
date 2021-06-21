//package com.hotel.FunctionMicro.Repository;
//
//import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.stereotype.Repository;
//
//import com.hotel.FunctionMicro.entity.User;
//
//import java.util.Optional;
//
//@Repository
//public interface UserRepository extends MongoRepository<User, Long> {
//    Optional<User> findByUsername(String username);
//
//    Boolean existsByUsername(String username);
//
//    Boolean existsByEmpId(String email);
//}
