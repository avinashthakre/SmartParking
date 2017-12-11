package com.infy.parking.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.infy.parking.dao.UserDao;
import com.infy.parking.models.UserDetails;
import com.infy.parking.service.UserService;

public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void persistUsersDetails(UserDetails user) throws Exception {
		try {
			userDao.saveUser(user);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

}
