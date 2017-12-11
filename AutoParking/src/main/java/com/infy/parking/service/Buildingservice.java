package com.infy.parking.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.infy.parking.models.BuildingDetails;


public interface Buildingservice {

	public void persistBuildingDetails(BuildingDetails buildingDetails) throws Exception;
	public List<BuildingDetails> getBuildingDetails()throws Exception;
	
}
