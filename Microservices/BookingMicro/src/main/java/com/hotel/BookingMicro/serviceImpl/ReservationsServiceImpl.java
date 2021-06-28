package com.hotel.BookingMicro.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.BookingMicro.Repository.ReservationsRepository;
import com.hotel.BookingMicro.entity.Reservations;
import com.hotel.BookingMicro.model.ReservationsDto;
import com.hotel.BookingMicro.service.ReservationsService;


@Service
public class ReservationsServiceImpl implements ReservationsService{

	@Autowired
	ReservationsRepository reservationsRepository;
	
	public String saveReservations(ReservationsDto reservationsDto) {
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
	
	 public List<ReservationsDto> getAllReservations(){
		 
		 List<Reservations> staffList= reservationsRepository.findAll();
			
			List<ReservationsDto> result = new ArrayList<ReservationsDto>();
			if(!staffList.isEmpty()) {
				for(Reservations s:staffList){
					ReservationsDto reservationsDto = new ReservationsDto(s.getId(),s.getCategory(),s.getRoomNo(),
							s.getCheckIn(),s.getCheckOut(),s.getName(),s.getContactNo(),s.getEmail(),
							s.getAddressProof(),s.getProofId(),s.getPaymentStatus(),s.getCompany(),
							s.getCity(),s.getSpoc(),s.getPaymentType(),s.getAmount(),s.getStatus());
					result.add(reservationsDto);
				}
			}
		return result;
	 }
		
	    public ReservationsDto findById(String id) {
	    	ReservationsDto reservationsDto = null;
			Optional<Reservations> reservations = reservationsRepository.findById(id);
			
			if(reservations.isPresent()) {
				Reservations s =reservations.get();
				reservationsDto = new ReservationsDto(s.getId(),s.getCategory(),s.getRoomNo(),
						s.getCheckIn(),s.getCheckOut(),s.getName(),s.getContactNo(),s.getEmail(),
						s.getAddressProof(),s.getProofId(),s.getPaymentStatus(),s.getCompany(),
						s.getCity(),s.getSpoc(),s.getPaymentType(),s.getAmount(),s.getStatus());
			}
			
		    return reservationsDto;	
	    }
		
	    
	    public ReservationsDto findByRoomNo(String roomNo) {
	    	ReservationsDto reservationsDto = null;
			Reservations s = reservationsRepository.findByRoomNo(roomNo);
			
			if(null != s) {
				reservationsDto = new ReservationsDto(s.getId(),s.getCategory(),s.getRoomNo(),
						s.getCheckIn(),s.getCheckOut(),s.getName(),s.getContactNo(),s.getEmail(),
						s.getAddressProof(),s.getProofId(),s.getPaymentStatus(),s.getCompany(),
						s.getCity(),s.getSpoc(),s.getPaymentType(),s.getAmount(),s.getStatus());
			}

		    return reservationsDto;	
	    }
	    
	    
		public String deleteReservationsById(String id) {
			reservationsRepository.deleteById(id);
			return id;
		}

		@Override
		public String updateReservations(ReservationsDto reservationsDto) {
			Optional<Reservations> room = reservationsRepository.findById(reservationsDto.getId());
			Reservations savedRoom = null;
			if(room.isPresent()){
				savedRoom =  reservationsRepository.save(new Reservations(reservationsDto.getId(),
						reservationsDto.getCategory(),reservationsDto.getRoomNo(),
						reservationsDto.getCheckin(),reservationsDto.getCheckout(),
						reservationsDto.getName(),reservationsDto.getContactNo(),
						reservationsDto.getEmail(),reservationsDto.getAddressProof(),
						reservationsDto.getProofId(),reservationsDto.getPaymentStatus(),reservationsDto.getCompany(),
						reservationsDto.getCity(),reservationsDto.getSpoc(),reservationsDto.getPaymentType(),
						reservationsDto.getAmount(),reservationsDto.getStatus()));
				return savedRoom.getRoomNo();
			}else{
				return "Unable to find Room";
			}
		}

}
