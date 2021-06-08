package com.hotel.BookingMicro.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;

@CrossOrigin(exposedHeaders = {HttpHeaders.CONTENT_DISPOSITION})
@RestController
@RequestMapping("/booking")
public class HotelBookingController {
	
	  @GetMapping(value = "/test/hm")
	    public String testHm() {
	        return "Booking set up done!!";
	    }

}