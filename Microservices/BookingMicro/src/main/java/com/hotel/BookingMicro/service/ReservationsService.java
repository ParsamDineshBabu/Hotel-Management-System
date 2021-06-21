package com.hotel.BookingMicro.service;

import java.util.List;

import com.hotel.BookingMicro.model.ReservationsDto;


public interface ReservationsService {

	public String saveReservations(ReservationsDto reservationsDto);
	
    public List<ReservationsDto> getAllReservations();
    public String updateReservations(ReservationsDto reservationsDto);
	
    public ReservationsDto findById(String id);
    
    public ReservationsDto findByRoomNo(String id);
	
	public String deleteReservationsById(String id);
}
