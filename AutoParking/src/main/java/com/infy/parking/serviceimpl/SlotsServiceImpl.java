package com.infy.parking.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;

import com.infy.parking.dao.SlotsDao;
import com.infy.parking.models.SlotDetails;
import com.infy.parking.service.SlotsService;

public class SlotsServiceImpl implements SlotsService {

	@Autowired
	private SlotsDao slotDao;
	@Override
	public void persistSlotsDetails(SlotDetails slotDetails)throws Exception {
		try {
			slotDao.save(slotDetails);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}

}
