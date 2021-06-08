package com.hotel.MasterMicro.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.MasterMicro.model.ReturnResponse;
import com.hotel.MasterMicro.model.RoomModel;
import com.hotel.MasterMicro.service.RoomService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@CrossOrigin(exposedHeaders = {HttpHeaders.CONTENT_DISPOSITION})
@RestController
@RequestMapping("/master")
@SuppressWarnings("unchecked")
public class MasterController {
	
	@Autowired
	RoomService roomServiceImpl;
	
	
	    @GetMapping("/test/hotel")
	    public String test() {
	        return "Master is working";
	    }
	    
		/* Creating Room in MongoDB whose collection is rooms */
	    
		
		@PostMapping(value = "/create/room")
		public ResponseEntity<String> createRoom(@RequestBody RoomModel roomDto) {
			
			return new ResponseEntity(roomServiceImpl.createRoom(roomDto), HttpStatus.OK);
		}
	
		/* Reading details which belongs to Room in MongoDB whose collection is rooms */
		
		
		@GetMapping(value="/getAll/rooms")
	    public ResponseEntity<List<RoomModel>> getAllRooms(){
			return new ResponseEntity(roomServiceImpl.getAllRooms(), HttpStatus.OK);
		}
		
		/* Reading particular room data which belongs to Room in MongoDB whose collection is rooms */
		
		@GetMapping(value="/getroom/byid/{id}")
		
		  public ResponseEntity<String> findRoomById(@PathVariable String id){ return
		  new ResponseEntity(roomServiceImpl.findById(id), HttpStatus.OK);
		  
		  }
		 
		/* Updating Room in MongoDB whose collection is rooms */

		@PutMapping(value = "/update/room")
		public ResponseEntity<String> updateRoom(@RequestBody RoomModel roomDto) {

			return new ResponseEntity(new ReturnResponse(roomServiceImpl.updateRoom(roomDto)), HttpStatus.OK);
		}
		
		/* Deleting Room in MongoDB where collection is rooms */
		
		@DeleteMapping(value="/deleteroom/byid/{id}")
	    public ResponseEntity<String> deleteRoomById(@PathVariable String id){
			String success=roomServiceImpl.deleteRoomById(id);
			return new ResponseEntity(new ReturnResponse(success), HttpStatus.OK);
			
		}

}
