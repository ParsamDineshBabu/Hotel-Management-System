package com.hotel.RolesMicro.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.RolesMicro.Repository.GuestRepository;
import com.hotel.RolesMicro.entity.Guest;
import com.hotel.RolesMicro.model.GuestModel;
import com.hotel.RolesMicro.service.GuestService;

@Service
public class GuestServiceImpl implements GuestService{

	@Autowired
	GuestRepository guestRepository;

	@Override
	public String createGuest(GuestModel guestDto) {
		Guest guest = new Guest(guestDto.getFullName(),guestDto.getAge(),guestDto.getEmail(),guestDto.getContactNo(),guestDto.getNoOfAdults(),guestDto.getNoOfChild());
		Guest savedGuest =  guestRepository.save(guest);
		return savedGuest.getFullName()+"Guest Created";
	}

	@Override
	public String updateGuest(GuestModel guestDto) {
		Optional<Guest> guest = guestRepository.findById(guestDto.getFullName());
		Guest savedGuest = null;
		if(guest.isPresent()){
			savedGuest =  guestRepository.save(new Guest(guestDto.getFullName(),guestDto.getAge(),guestDto.getEmail(),guestDto.getContactNo(),guestDto.getNoOfAdults(),guestDto.getNoOfChild()));
			return "Guest Updated";
		}
		else{
			return "Unable to find Guest";
		}
	}

	@Override
	public String deleteGuestById(String fullName) {
		guestRepository.deleteById(fullName);
		return "Owner Deleted";
	}

	@Override
	public List<GuestModel> getAllGuests() {
		List<Guest> guestList = guestRepository.findAll();
		
		List<GuestModel> result = new ArrayList<GuestModel>();
		
		for(Guest guest:guestList) {
			GuestModel roomDto = new GuestModel(guest.getFullName(),guest.getAge(),guest.getEmail(),guest.getContactNo(),guest.getNoOfAdults(),guest.getNoOfChild());
			result.add(roomDto);
		}
		
		return result;
	}
}
