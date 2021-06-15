package com.hotel.BookingMicro.serviceImpl;

import java.util.ArrayList;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.BookingMicro.Repository.ReservationRepository;
import com.hotel.BookingMicro.entity.Reservations;
import com.hotel.BookingMicro.model.ReservationModel;
import com.hotel.BookingMicro.service.ReservationService;

@Service
public class ReservationServiceImpl implements ReservationService{
	
	@Autowired
	ReservationRepository reservationsRepository;

	@Override
	public String saveReservations(ReservationModel reservationsDto) {
		Reservations reservation = new Reservations(reservationsDto.getId(),
				reservationsDto.getCategory(),reservationsDto.getRoomNo(),
				reservationsDto.getCheckin(),reservationsDto.getCheckout(),
				reservationsDto.getName(),reservationsDto.getContactNo(),
				reservationsDto.getEmail(),reservationsDto.getAddressProof(),
				reservationsDto.getProofId(),reservationsDto.getPaymentStatus(),reservationsDto.getCompany(),
				reservationsDto.getCity(),reservationsDto.getSpoc(),reservationsDto.getPaymentType(),
				reservationsDto.getAmount(),reservationsDto.getStatus());

		Reservations confirmedReservation =reservationsRepository.save(reservation);
		
		return confirmedReservation.getId();
	}

	@Override
	public List<ReservationModel> getAllReservations() {
		 List<Reservations> staffList= reservationsRepository.findAll();
			
			List<ReservationModel> result = new ArrayList<ReservationModel>();
			if(!staffList.isEmpty()) {
				for(Reservations s:staffList){
					ReservationModel reservationsDto = new ReservationModel(s.getId(),s.getCategory(),s.getRoomNo(),
							s.getCheckIn(),s.getCheckOut(),s.getName(),s.getContactNo(),s.getEmail(),
							s.getAddressProof(),s.getProofId(),s.getPaymentStatus(),s.getCompany(),
							s.getCity(),s.getSpoc(),s.getPaymentType(),s.getAmount(),s.getStatus());
					result.add(reservationsDto);
				}
			}
		return result;
	}

	@Override
	public ReservationModel findById(String id) {
		ReservationModel reservationsDto = null;
		Optional<Reservations> reservations = reservationsRepository.findById(id);
		
		if(reservations.isPresent()) {
			Reservations s =reservations.get();
			reservationsDto = new ReservationModel(s.getId(),s.getCategory(),s.getRoomNo(),
					s.getCheckIn(),s.getCheckOut(),s.getName(),s.getContactNo(),s.getEmail(),
					s.getAddressProof(),s.getProofId(),s.getPaymentStatus(),s.getCompany(),
					s.getCity(),s.getSpoc(),s.getPaymentType(),s.getAmount(),s.getStatus());
		}
		
	    return reservationsDto;	
	}

	@Override
	public ReservationModel findByRoomNo(String roomNo) {
		ReservationModel reservationsDto = null;
		Reservations s = reservationsRepository.findByRoomNo(roomNo);
		
		if(null != s) {
			reservationsDto = new ReservationModel(s.getId(),s.getCategory(),s.getRoomNo(),
					s.getCheckIn(),s.getCheckOut(),s.getName(),s.getContactNo(),s.getEmail(),
					s.getAddressProof(),s.getProofId(),s.getPaymentStatus(),s.getCompany(),
					s.getCity(),s.getSpoc(),s.getPaymentType(),s.getAmount(),s.getStatus());
		}
		
	    return reservationsDto;	
	}

	@Override
	public String deleteReservationsById(String id) {
		reservationsRepository.deleteById(id);
		return id;
	}

}
