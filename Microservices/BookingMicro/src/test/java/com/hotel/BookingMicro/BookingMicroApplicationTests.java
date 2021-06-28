package com.hotel.BookingMicro;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.hotel.BookingMicro.controller.HotelBookingController;
import com.hotel.BookingMicro.model.ReturnResponse;
import com.hotel.BookingMicro.service.ReservationsService;

@SpringBootTest
@SuppressWarnings({"rawtypes","unchecked"})
class BookingMicroApplicationTests {
	
    @InjectMocks
    HotelBookingController bookingController;
	
    @Mock
    ReservationsService reservationsServiceImpl;

	@Test
	void contextLoads() {
		Assert.assertEquals("Booking set up done!!",bookingController.testbooking());
	}
    @Test
    public void testDeleteReservationsById(){
       Mockito.when(reservationsServiceImpl.deleteReservationsById(Mockito.anyString())).thenReturn("Success");
       Assert.assertEquals(new ResponseEntity(new ReturnResponse("Success"), HttpStatus.OK),
              bookingController.deleteReservationsById(Mockito.anyString()));
  }
//    @Test
//    public  void testSaveReservations(){
//        Mockito.when(reservationsServiceImpl.saveReservations(Mockito.any())).thenReturn("Success");
//        Assert.assertEquals(new ResponseEntity("Success", HttpStatus.OK),bookingController.saveReservation(Mockito.any()));
//    }

}
