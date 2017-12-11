/**
 * 
 */
package com.infy.parking.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SLOTS_DETAILS")
public class SlotDetails {

	@Id
	@Column(name="SLOT_ID")
	private String slotId;
	
	@Column(name="BUILDING_ID")
	private String buildingId;

	public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}

	public String getBuildingId() {
		return buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}
	
	
}
