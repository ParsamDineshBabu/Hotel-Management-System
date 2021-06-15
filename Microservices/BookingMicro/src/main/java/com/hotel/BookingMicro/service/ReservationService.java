package com.hotel.BookingMicro.service;

import java.util.List;

import com.hotel.BookingMicro.model.ReservationModel;

public interface ReservationService {
   public String saveReservations(ReservationModel reservationsDto);
	
    public List<ReservationModel> getAllReservations();
	
    public ReservationModel findById(String id);
    
    public ReservationModel findByRoomNo(String roomNo);
	
	public String deleteReservationsById(String id);

}
