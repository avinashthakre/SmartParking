package com.infy.parking.dao;

import com.infy.parking.models.UserDetails;

public interface UserDao {
	public void saveUser(UserDetails user) throws Exception;
	public boolean validateUser(UserDetails userDetails)throws Exception;
}
