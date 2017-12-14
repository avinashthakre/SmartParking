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
public class SlotDetails extends StatusDetails {

	@Id
	@Column(name="SLOT_ID")
	private String slotId;
	
	@Column(name="BUILDING_ID")
	private String buildingId;

	@Column(name="RESERVED")
	private int reserved;
	
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

	public int getReserved() {
		return reserved;
	}

	public void setReserved(int reserved) {
		this.reserved = reserved;
	}

	@Override
	public String toString() {
		return "SlotDetails [slotId=" + slotId + ", buildingId=" + buildingId + ", reserved=" + reserved + "]";
	}
	
	
}
