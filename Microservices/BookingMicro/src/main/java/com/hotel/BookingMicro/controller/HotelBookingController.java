package com.hotel.BookingMicro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.BookingMicro.model.ReservationModel;
import com.hotel.BookingMicro.service.ReservationService;

@CrossOrigin(exposedHeaders = {HttpHeaders.CONTENT_DISPOSITION})
@RestController
@RequestMapping("/booking")
public class HotelBookingController {
	@Autowired
	ReservationService reservationsServiceImpl;

	@GetMapping(value = "/")
	public String testbooking() {
		return "hello";
	}

	@PostMapping(value = "/create/reservation")
	public ResponseEntity saveReservation(@RequestBody ReservationModel reservationsDto) {

		return new ResponseEntity(reservationsServiceImpl.saveReservations(reservationsDto), HttpStatus.OK);

	}	
	@GetMapping(value="/getAll/reservations")
	public ResponseEntity<List<ReservationModel>> getAllReservations(){
		return new ResponseEntity(reservationsServiceImpl.getAllReservations(), HttpStatus.OK);

	}

	@GetMapping(value="/getreservation/byid/{id}")
	public ResponseEntity<ReservationModel> findReservationById(@PathVariable String id){
		return new ResponseEntity(reservationsServiceImpl.findById(id), HttpStatus.OK);

	}

	@GetMapping(value="/findByroomNo/{roomNo}")
	public ResponseEntity<ReservationModel> findReservationRoomNo(@PathVariable String roomNo){
		return new ResponseEntity(reservationsServiceImpl.findByRoomNo(roomNo), HttpStatus.OK);

	}

	@DeleteMapping(value="/deletereservations/byid/{id}")
	public ResponseEntity<String> deleteReservationsById(@PathVariable String id){
		String success=reservationsServiceImpl.deleteReservationsById(id);
		return new ResponseEntity("success", HttpStatus.OK);

	}
}
