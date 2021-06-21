package com.hotel.RolesMicro.service;
import java.util.List;

import com.hotel.RolesMicro.model.GuestModel;

public interface GuestService {
    public String createGuest(GuestModel guestDto);
	
	public String updateGuest(GuestModel guestDto);
	
	public String deleteGuestById(String fullName);

	public List<GuestModel> getAllGuests();

}
