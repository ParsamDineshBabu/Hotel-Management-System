package com.hotel.MasterMicro.service;

import com.hotel.MasterMicro.model.RoomModel;
import java.util.List;

public interface RoomService {
	public String createRoom(RoomModel roomDto);
	
	public String updateRoom(RoomModel roomDto);
		
	public List<RoomModel> getAllRooms();
	
    public RoomModel findById(String id);
	
	public String deleteRoomById(String id);

}
