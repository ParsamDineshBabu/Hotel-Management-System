package com.hotel.RolesMicro.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.RolesMicro.entity.Guest;

@Repository
public interface GuestRepository extends MongoRepository<Guest, String>{

}
