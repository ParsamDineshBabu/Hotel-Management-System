package com.hotel.BookingMicro.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.BookingMicro.entity.Reservations;

@Repository
public interface ReservationsRepository  extends MongoRepository<Reservations, String>{

    public Reservations findByRoomNo(String RoomNo);
}
