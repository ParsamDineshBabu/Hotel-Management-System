package com.hotel.RolesMicro.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.RolesMicro.Repository.OwnerRepository;
import com.hotel.RolesMicro.entity.Owner;
import com.hotel.RolesMicro.model.OwnerModel;
import com.hotel.RolesMicro.service.OwnerService;

@Service
public class OwnerServiceImpl implements OwnerService{
	
	@Autowired
	OwnerRepository ownerRepository;

	@Override
	public String createOwner(OwnerModel ownerDto) {
		Owner owner = new Owner(ownerDto.getUsername(),ownerDto.getPassword());
		Owner savedOwner =  ownerRepository.save(owner);
		return "Owner Created";
	}

	@Override
	public String updateOwner(OwnerModel ownerDto) {
		Optional<Owner> owner = ownerRepository.findById(ownerDto.getUsername());
		Owner savedOwner = null;
		if(owner.isPresent()){
			savedOwner =  ownerRepository.save(new Owner(ownerDto.getUsername(),ownerDto.getPassword()));
			return "Owner Updated";
		}
		else{
			return "Unable to find Owner";
		}
	}

	@Override
	public String deleteOwnerById(String username) {
		ownerRepository.deleteById(username);
		return "Owner Deleted";
	}
}
