package com.hotel.RolesMicro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hotel.RolesMicro.model.GuestModel;
import com.hotel.RolesMicro.service.GuestService;


import io.swagger.annotations.ApiOperation;

@CrossOrigin(exposedHeaders = {HttpHeaders.CONTENT_DISPOSITION})
@RestController
@RequestMapping("/roles")
@SuppressWarnings({"unchecked","rawtypes"})
public class GuestController {
	
    @Autowired
    GuestService guestServiceImpl;
    

    
    /* Creating Guest in MongoDB whose collection is guest */
    
	@ApiOperation(value = "It Will Create Guest",notes="this just create guest")
	@PostMapping(value = "/createGuest")
	public ResponseEntity<String> createGuest(@RequestBody GuestModel guestDto) {
		
		return new ResponseEntity(guestServiceImpl.createGuest(guestDto), HttpStatus.CREATED);
	}
	
	/* Reading details which belongs to Guest in MongoDB whose collection is guest */
	
	@ApiOperation(value = "It Will Provide all Guest Details ")
	@GetMapping(value="/getAllGuest")
    public List<GuestModel> getAllRooms(){
		return guestServiceImpl.getAllGuests();
	}
	
	/* Updating Guest in MongoDB whose collection is guest */
	
	@ApiOperation(value = "It Will Update the Guest Details")
	@PutMapping(value = "/updateGuest")
	public ResponseEntity<String> updateGuest(@RequestBody GuestModel guestDto) {

		return new ResponseEntity(guestServiceImpl.updateGuest(guestDto), HttpStatus.OK);
	}
	
	/* Deleting Guest in MongoDB where collection is guest */
	
	@ApiOperation(value = "It Will Delete the Guest Details with Fullname")
	@DeleteMapping(value="/deleteGuest/byname/{fullName}")
    public ResponseEntity<String> deleteGuestById(@PathVariable String fullName){
		String success=guestServiceImpl.deleteGuestById(fullName);
		return new ResponseEntity("sucess", HttpStatus.OK);
		
	}

}
