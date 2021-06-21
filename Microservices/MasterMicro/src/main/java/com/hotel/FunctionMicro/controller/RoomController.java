package com.hotel.FunctionMicro.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.FunctionMicro.model.EmployeeDto;
import com.hotel.FunctionMicro.model.ReturnResponse;
import com.hotel.FunctionMicro.model.RoomDto;
import com.hotel.FunctionMicro.service.EmployeeService;
import com.hotel.FunctionMicro.service.RoomService;

@CrossOrigin(exposedHeaders = {HttpHeaders.CONTENT_DISPOSITION})
@RestController
@RequestMapping("/master")
public class RoomController {

   @Autowired
   RoomService roomServiceImpl;
   
   @ExceptionHandler(value = Exception.class)
	public ResponseEntity<Object> exception(Exception e) {

		return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
   
   @PostMapping(value = "/save/room")
	public ResponseEntity<String> saveRoom(@RequestBody RoomDto roomDto) {
		
		return new ResponseEntity(roomServiceImpl.saveRoom(roomDto), HttpStatus.OK);
	}
   
   @GetMapping(value="/getAll/rooms")
   public ResponseEntity<List<RoomDto>> getAllRooms(){
		return new ResponseEntity(roomServiceImpl.getAllRooms(), HttpStatus.OK);
		
	}
   @GetMapping(value="/getroom/byid/{id}")
   public ResponseEntity<EmployeeDto> findRoomById(@PathVariable String id){
		return new ResponseEntity(roomServiceImpl.findById(id), HttpStatus.OK);
		
	}
   
   @PutMapping(value = "/update/room")
   public ResponseEntity<String> updateRoom(@RequestBody RoomDto roomDto) {


	    return new ResponseEntity(new ReturnResponse(roomServiceImpl.updateRoom(roomDto)), HttpStatus.OK);
   }
	
	@DeleteMapping(value="/deleteroom/byid/{id}")
   public ResponseEntity<String> deleteRoomById(@PathVariable String id){
		String success=roomServiceImpl.deleteRoomById(id);
		return new ResponseEntity(new ReturnResponse(success), HttpStatus.OK);
		
	}
   

   @GetMapping(value="/search/rooms/{checkin}/{checkout}")
	public ResponseEntity<List<RoomDto>> searchRooms(@PathVariable String checkin, @PathVariable String checkout) throws ParseException {
  	   SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date requiredCheckin = simpleDateFormat.parse(checkin);
		Date requiredCheckout = simpleDateFormat.parse(checkout);
		return new ResponseEntity(roomServiceImpl.searchRooms(requiredCheckin, requiredCheckout), HttpStatus.OK);
		
	}
}
