package com.infy.parking.dao;

import java.util.List;

import com.infy.parking.models.BuildingDetails;

public interface BuildingDao {

	public void save(BuildingDetails buildingDetails) throws Exception;
	public void edit(BuildingDetails buildingDetails)throws Exception;
	public List<BuildingDetails> getBuildingDetails()throws Exception;
	
}
