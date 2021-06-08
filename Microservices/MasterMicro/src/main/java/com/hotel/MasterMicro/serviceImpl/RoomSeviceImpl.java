package com.hotel.MasterMicro.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.reactive.ReactiveOAuth2ResourceServerAutoConfiguration;
import org.springframework.stereotype.Service;

import com.hotel.MasterMicro.Repository.RoomRepository;
import com.hotel.MasterMicro.entity.Room;
import com.hotel.MasterMicro.model.RoomModel;
import com.hotel.MasterMicro.service.RoomService;


@Service
public class RoomSeviceImpl implements RoomService {
	
	@Autowired
	RoomRepository roomRepository;

    @Override
	public String createRoom(RoomModel roomDto) {

		Room room = new Room(roomDto.getId(),roomDto.getRoomNo(), roomDto.getFloor(), roomDto.getCategory(), roomDto.getCapacity(),
				roomDto.getPrice(),roomDto.isBooked());
		System.out.println("Booked"+roomDto.isBooked());

		Room savedRoom =  roomRepository.save(room);

		return savedRoom.getRoomNo();
	}
    @Override
	public String updateRoom(RoomModel roomDto) {

		Optional<Room> room = roomRepository.findById(roomDto.getId());
		System.out.println("Booked"+roomDto.isBooked());
		Room savedRoom = null;
		if(room.isPresent()){
			savedRoom =  roomRepository.save(new Room(roomDto.getId(),roomDto.getRoomNo(), roomDto.getFloor(), roomDto.getCategory(), roomDto.getCapacity(),
					roomDto.getPrice(),roomDto.isBooked()));
			return savedRoom.getRoomNo();
		}else{
			return "Unable to fnd Room";
		}

	}

	public boolean isWithinRange(Date testDate,Date startDate, Date endDate) {

		return testDate.getTime() >= startDate.getTime() &&
				testDate.getTime() <= endDate.getTime();
	}
	@Override
	public List<RoomModel> getAllRooms(){
		
		List<Room> roomsList = roomRepository.findAll();
		
		List<RoomModel> result = new ArrayList<RoomModel>();
		
		for(Room room:roomsList) {
			RoomModel roomDto = new RoomModel(room.getId(),room.getRoomNo(),room.getFloor(),room.getCategory(),room.getCapacity(),room.getPrice(),room.isBooked());
			result.add(roomDto);
		}
		
		return result;
	}
	@Override
	 public RoomModel findById(String id) {
		 
		    RoomModel roomDto = null;
			Optional<Room> room = roomRepository.findById(id);
			
			if(room.isPresent()) {
				Room s =room.get();
				roomDto = new RoomModel(s.getId(),s.getRoomNo(),s.getFloor(),s.getCategory(),s.getCapacity(),s.getPrice(),s.isBooked());
			}
			
		    return roomDto;
	 }
	@Override
	public String deleteRoomById(String id) {
		roomRepository.deleteById(id);
		return "test";
	}
		
	

}
