package com.infy.parking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BUILDING_DETAILS")
public class BuildingDetails extends StatusDetails{

	@Id
	@Column(name="BUILDING_ID")
	private String buildingId;
	
	@Column(name="BUILDING_NAME")
	private String buildingName;
	
	public String getBuildingId() {
		return buildingId;
	}
	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	public String getBuildingName() {
		return buildingName;
	}
	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}
	@Override
	public String toString() {
		return "BuildingDetails [buildingId=" + buildingId + ", buildingName=" + buildingName + "]";
	}
	
	
	
}
