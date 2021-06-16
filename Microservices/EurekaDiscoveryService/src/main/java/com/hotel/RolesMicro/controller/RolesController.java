package com.hotel.RolesMicro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hotel.RolesMicro.model.OwnerModel;
import com.hotel.RolesMicro.service.OwnerService;

import io.swagger.annotations.ApiOperation;

@CrossOrigin(exposedHeaders = {HttpHeaders.CONTENT_DISPOSITION})
@RestController
@RequestMapping("/roles")
@SuppressWarnings("unchecked")

public class RolesController {
	
    @Autowired
    OwnerService ownerServiceImpl;
    
//    @GetMapping("/test")
//    public String test() {
//        return "Roles is working";
//    }
    
    @ApiOperation(value = "It Will Create Owner",notes="this just create owner")
	@PostMapping(value = "/create/owner")
	public ResponseEntity<String> createOwner(@RequestBody OwnerModel ownerDto) {
		
		return new ResponseEntity(ownerServiceImpl.createOwner(ownerDto), HttpStatus.CREATED);
	}
    
	@PutMapping(value = "/update/owner")
	public ResponseEntity<String> updateOwner(@RequestBody OwnerModel ownerDto) {

		return new ResponseEntity(ownerServiceImpl.updateOwner(ownerDto), HttpStatus.OK);
	}
	
	@DeleteMapping(value="/deleteowner/byuser/{username}")
    public ResponseEntity<String> deleteOwnerById(@PathVariable String username){
		return new ResponseEntity("Sucess", HttpStatus.OK);
		
	}

}
