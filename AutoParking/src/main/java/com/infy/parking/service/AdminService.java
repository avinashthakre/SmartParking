package com.infy.parking.service;

import com.infy.parking.models.AdminDetails;

public interface AdminService {

	public boolean authenticateAdmin(AdminDetails admin) throws Exception;
	
}
