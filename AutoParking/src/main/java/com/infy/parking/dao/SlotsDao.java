package com.infy.parking.dao;

import java.util.List;

import com.infy.parking.models.ReservedSlot;
import com.infy.parking.models.SlotDetails;

public interface SlotsDao {
	public void save(SlotDetails slotDetails) throws Exception;
	public void saveList(List<SlotDetails> slotDetails) throws Exception;
	public void update(SlotDetails slotDetails) throws Exception;
	public SlotDetails getAvailableSlot()throws Exception;
	public void bookSlot(ReservedSlot slot)throws Exception;
	
}
