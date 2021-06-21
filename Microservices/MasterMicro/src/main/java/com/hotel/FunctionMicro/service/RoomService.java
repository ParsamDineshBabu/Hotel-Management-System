package com.hotel.FunctionMicro.service;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import com.hotel.FunctionMicro.model.RoomDto;


public interface RoomService {

	public String saveRoom(RoomDto roomDto);
	public String updateRoom(RoomDto roomDto);
	
	public List<RoomDto> searchRooms(Date requiredCheckin, Date requiredCheckout) throws ParseException;
	
	public List<RoomDto> getAllRooms();
	
    public RoomDto findById(String id);
	
	public String deleteRoomById(String id);
}
