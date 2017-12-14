package com.infy.parking.service;

import java.util.List;

import com.infy.parking.models.SlotDetails;
import com.infy.parking.models.UserDetails;

public interface SlotsService {

	public void persistSlotsDetails(SlotDetails slotDetails) throws Exception;
	public void persistSlotsDetailsList(List<SlotDetails> slotDetails) throws Exception;
	public SlotDetails getslotDetails() throws Exception;
	void bookSlot(UserDetails user, SlotDetails slot) throws Exception;
	public void updateSlotsDetails(SlotDetails slotDetails) throws Exception;
}
