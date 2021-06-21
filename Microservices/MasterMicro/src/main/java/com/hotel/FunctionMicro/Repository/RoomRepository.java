package com.hotel.FunctionMicro.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.FunctionMicro.entity.Room;

@Repository
public interface RoomRepository extends MongoRepository<Room, String>{

}
