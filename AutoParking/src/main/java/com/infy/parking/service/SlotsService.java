package com.infy.parking.service;

import java.util.List;

import com.infy.parking.models.SlotDetails;

public interface SlotsService {

	public void persistSlotsDetails(SlotDetails slotDetails) throws Exception;
	public void persistSlotsDetailsList(List<SlotDetails> slotDetails) throws Exception;
}
