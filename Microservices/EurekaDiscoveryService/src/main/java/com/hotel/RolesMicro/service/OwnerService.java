package com.hotel.RolesMicro.service;
import com.hotel.RolesMicro.model.OwnerModel;

public interface OwnerService {
    public String createOwner(OwnerModel ownerDto);
	
	public String updateOwner(OwnerModel ownerDto);
	
	public String deleteOwnerById(String username);

}
