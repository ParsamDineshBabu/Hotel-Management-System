package com.hotel.BookingMicro.controller;


import java.io.ByteArrayInputStream;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.hotel.BookingMicro.model.ReservationsDto;
import com.hotel.BookingMicro.model.ReturnResponse;
import com.hotel.BookingMicro.service.ReservationsService;
import com.hotel.BookingMicro.utility.PDFGenerator;

import io.swagger.annotations.ApiOperation;


@CrossOrigin
@RestController
@RequestMapping("/booking")
@SuppressWarnings({"rawtypes","unchecked"})
public class HotelBookingController {

	@Autowired
	ReservationsService reservationsServiceImpl;

	@GetMapping(value = "/test/booking")
	public String testbooking() {


		return "Booking set up done!!";
	}
	
	/* Creating Booking in MongoDB whose collection name is Booking  */

	@ApiOperation(value = "It Will Book the Room",notes="this just create book")
	@PostMapping(value = "/save/reservation")
	public ResponseEntity saveReservation(@RequestBody ReservationsDto reservationsDto) {

		reservationsServiceImpl.saveReservations(reservationsDto);

		ByteArrayInputStream bis = PDFGenerator.customerPDFReport(reservationsDto);
		String filename = "booking"+"-"+reservationsDto.getName()+".pdf";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename="+filename);

		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+filename);
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");
		return ResponseEntity
				.ok()
				.headers(header)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

	/* Reading details which belongs to Booking in MongoDB whose collection name is Booking */

	@ApiOperation(value = "It Will Provide all Booking Details ")
	@GetMapping(value="/getAll/reservations")
	public ResponseEntity<List<ReservationsDto>> getAllReservations(){
		return new ResponseEntity(reservationsServiceImpl.getAllReservations(), HttpStatus.OK);

	}
	
	/* Reading particular Booking data which belongs to Booking in MongoDB whose collection name is Booking */

	@ApiOperation(value = "It Will Provide Booking Details with the help of ID")
	@GetMapping(value="/getreservation/byid/{id}")
	public ResponseEntity<ReservationsDto> findReservationById(@PathVariable String id){
		return new ResponseEntity(reservationsServiceImpl.findById(id), HttpStatus.OK);

	}

	@GetMapping(value="/findByroomNo/{roomNo}")
	public ResponseEntity<ReservationsDto> findReservationRoomNo(@PathVariable String roomNo){
		return new ResponseEntity(reservationsServiceImpl.findByRoomNo(roomNo), HttpStatus.OK);

	}

	/* Updating Booking in MongoDB whose collection name is Booking */

	@ApiOperation(value = "It Will Update the Booking Details")
	@PutMapping(value = "/update/reservation")
	public ResponseEntity updateReservations(@RequestBody ReservationsDto reservationsDto) {

		reservationsServiceImpl.findById(reservationsDto.getId());

		reservationsServiceImpl.saveReservations(reservationsDto);

		ByteArrayInputStream bis = PDFGenerator.customerPDFReport(reservationsDto);
		String filename = "booking"+"-"+reservationsDto.getName()+".pdf";
		HttpHeaders headers = new HttpHeaders();
		headers.add("Content-Disposition", "attachment; filename="+filename);

		HttpHeaders header = new HttpHeaders();
		header.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename="+filename);
		header.add("Cache-Control", "no-cache, no-store, must-revalidate");
		header.add("Pragma", "no-cache");
		header.add("Expires", "0");
		return ResponseEntity
				.ok()
				.headers(header)
				.contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

	/* Deleting Booking in MongoDB where collection name is Booking */

	@ApiOperation(value = "It Will Delete the Booking Details with Id")
	@DeleteMapping(value="/deletereservations/byid/{id}")
	public ResponseEntity<String> deleteReservationsById(@PathVariable String id){
		String success=reservationsServiceImpl.deleteReservationsById(id);
		return new ResponseEntity(new ReturnResponse(success), HttpStatus.OK);

	}
}
