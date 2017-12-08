package com.infy.parking.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infy.parking.dao.BuildingDao;
import com.infy.parking.models.BuildingDetails;
import com.infy.parking.service.Buildingservice;


public class BuildingServiceImpl implements Buildingservice {

	@Autowired
	private BuildingDao buildingDao;

	@Override
	public void persistBuildingDetails(BuildingDetails buildingDetails)throws Exception {
		try {
			buildingDao.save(buildingDetails);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

	
}
