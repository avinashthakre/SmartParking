package com.infy.parking.service;

import com.infy.parking.dao.SlotsDao;
import com.infy.parking.models.SlotDetails;

public interface SlotsService {

	public void persistSlotsDetails(SlotDetails slotDetails) throws Exception;
}
