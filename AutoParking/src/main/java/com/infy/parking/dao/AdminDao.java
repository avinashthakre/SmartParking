package com.infy.parking.dao;

import com.infy.parking.models.AdminDetails;

public interface AdminDao {
	public boolean authenticateAdmin(AdminDetails admin) throws Exception;
}
