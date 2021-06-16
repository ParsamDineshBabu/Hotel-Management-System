package com.hotel.RolesMicro.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.RolesMicro.entity.Owner;

@Repository
public interface OwnerRepository extends MongoRepository<Owner, String>{

}
