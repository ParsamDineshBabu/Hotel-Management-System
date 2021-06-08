package com.hotel.MasterMicro.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.MasterMicro.entity.Room;

@Repository
public interface RoomRepository extends MongoRepository<Room, String>{

}
