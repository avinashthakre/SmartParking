package com.infy.parking.dao;

import com.infy.parking.models.SlotDetails;

public interface SlotsDao {
	public void save(SlotDetails slotDetails) throws Exception;
	public void update(SlotDetails slotDetails) throws Exception;
	
}
