package com.infy.parking.service;

import com.infy.parking.models.UserDetails;

public interface UserService {
	public void persistUsersDetails(UserDetails user) throws Exception;
}
