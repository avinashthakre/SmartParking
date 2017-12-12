package com.infy.parking.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.infy.parking.dao.AdminDao;
import com.infy.parking.models.AdminDetails;
import com.infy.parking.service.AdminService;

public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Override
	public boolean authenticateAdmin(AdminDetails admin) throws Exception {
		try {
			return adminDao.authenticateAdmin(admin);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	return false;
	}
}
