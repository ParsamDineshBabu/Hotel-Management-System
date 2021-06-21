package com.hotel.FunctionMicro.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.reactive.ReactiveOAuth2ResourceServerAutoConfiguration;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.hotel.FunctionMicro.Repository.RoomRepository;
import com.hotel.FunctionMicro.entity.Room;
import com.hotel.FunctionMicro.model.RoomDto;
import com.hotel.FunctionMicro.service.RoomService;

@Service
public class RoomSeviceImpl implements RoomService {
	
	@Autowired
	RoomRepository roomRepository;

//	@Autowired
//	ReservationsRepository reservationsRepository;

    @Autowired
   // @Lazy
    private RestTemplate template;

	public String saveRoom(RoomDto roomDto) {

		Room room = new Room(roomDto.getId(),roomDto.getRoomNo(), roomDto.getFloor(), roomDto.getCategory(), roomDto.getCapacity(),
				roomDto.getPrice(),roomDto.isBooked());
		System.out.println("**************Booked"+roomDto.isBooked());

		Room savedRoom =  roomRepository.save(room);

		return savedRoom.getRoomNo();
	}
	public String updateRoom(RoomDto roomDto) {

		Optional<Room> room = roomRepository.findById(roomDto.getId());
		System.out.println("**************Booked"+roomDto.isBooked());
		Room savedRoom = null;
		if(room.isPresent()){
			savedRoom =  roomRepository.save(new Room(roomDto.getId(),roomDto.getRoomNo(), roomDto.getFloor(), roomDto.getCategory(), roomDto.getCapacity(),
					roomDto.getPrice(),roomDto.isBooked()));
			return savedRoom.getRoomNo();
		}else{
			return "Unable to fnd Room";
		}

	}
	
//	public List<RoomDto> searchRooms(Date requiredCheckin, Date requiredCheckout) throws ParseException {
//
//		/*SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
//		Date requiredCheckin = simpleDateFormat.parse(checkIn);
//		Date requiredCheckout = simpleDateFormat.parse(checkOut);*/
//		List<RoomDto> list = new ArrayList<RoomDto>();
//		//List<Reservations> bookings = reservationsRepository.findAll();
//		List<Room> rooms = roomRepository.findAll();
//		List<Room> roomsResult = new ArrayList<>();
//		
//		for(Room room:rooms) {
//			boolean booked = false;
//			System.out.println("Searching reservation with booking number-room-Start");
//			ResponseEntity<ReservationsDto> reservation = template.getForEntity("http://BOOKING-SERVICE/booking/findByroomNo/"+room.getRoomNo(), ReservationsDto.class);
//			System.out.println("called");
//			//Optional<Reservations> reservation = Optional.ofNullable(reservationsRepository.findByRoomNo(room.getRoomNo()));
//			if(null !=reservation.getBody()){
//				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//
//
//				if("Active".equalsIgnoreCase(reservation.getBody().getStatus())){
//					Date existingCheckin = reservation.getBody().getCheckin();
//					Date existingCheckout = reservation.getBody().getCheckout();
//					if(isWithinRange(requiredCheckin,existingCheckin, existingCheckout) ||
//							isWithinRange(requiredCheckout,existingCheckin, existingCheckout)){
//					}
//					booked  = true;
//				}
//
//			}
//			if(!booked) {
//				roomsResult.add(room);
//			}
//		};
//		roomsResult.forEach( room -> {
//			list.add(new RoomDto(room.getId(),room.getRoomNo(),room.getFloor(),room.getCategory(),room.getCapacity(),
//					room.getPrice(),room.isBooked()));
//		});
//
//
//		return list;
//	}
	
    public List<RoomDto> searchRooms(Date requiredCheckin, Date requiredCheckout) throws ParseException {

		
		List<RoomDto> list = new ArrayList<RoomDto>();
	
		List<Room> rooms = roomRepository.findAll();
		rooms.stream().filter( room -> {
			ResponseEntity<ReservationsDto> reservation = template.getForEntity("http://localhost:9191/booking/findByroomNo/"+room.getRoomNo(), ReservationsDto.class);
			System.out.println("called");
			
			if(null !=reservation){
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");


				if("Active".equalsIgnoreCase(reservation.getBody().getStatus())){
					Date existingCheckin = reservation.getBody().getCheckin();
					Date existingCheckout = reservation.getBody().getCheckout();
					if(isWithinRange(requiredCheckin,existingCheckin, existingCheckout) ||
							isWithinRange(requiredCheckout,existingCheckin, existingCheckout)){
						return false;
					}
				}else {
					return  true;
				}

			}
			return true;
		});
		rooms.forEach( room -> {
			list.add(new RoomDto(room.getId(),room.getRoomNo(),room.getFloor(),room.getCategory(),room.getCapacity(),
					room.getPrice(),room.isBooked()));
		});


		return list;
	}

	public boolean isWithinRange(Date testDate,Date startDate, Date endDate) {

		return testDate.getTime() >= startDate.getTime() &&
				testDate.getTime() <= endDate.getTime();
	}
	
	public List<RoomDto> getAllRooms(){
		
		List<Room> roomsList = roomRepository.findAll();
		
		List<RoomDto> result = new ArrayList<RoomDto>();
		
		for(Room room:roomsList) {
			RoomDto roomDto = new RoomDto(room.getId(),room.getRoomNo(),room.getFloor(),room.getCategory(),room.getCapacity(),room.getPrice(),room.isBooked());
			result.add(roomDto);
		}
		
		return result;
	}
	
	 public RoomDto findById(String id) {
		 
		    RoomDto roomDto = null;
			Optional<Room> room = roomRepository.findById(id);
			
			if(room.isPresent()) {
				Room s =room.get();
				roomDto = new RoomDto(s.getId(),s.getRoomNo(),s.getFloor(),s.getCategory(),s.getCapacity(),s.getPrice(),s.isBooked());
			}
			
		    return roomDto;
	 }
		
		public String deleteRoomById(String id) {
			roomRepository.deleteById(id);
			return "test";
		}

}
