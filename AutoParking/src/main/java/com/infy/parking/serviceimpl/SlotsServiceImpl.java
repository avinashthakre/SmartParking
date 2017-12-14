package com.infy.parking.serviceimpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.infy.parking.dao.SlotsDao;
import com.infy.parking.models.ReservedSlot;
import com.infy.parking.models.SlotDetails;
import com.infy.parking.models.UserDetails;
import com.infy.parking.service.SlotsService;

public class SlotsServiceImpl implements SlotsService {

	@Autowired
	private SlotsDao slotDao;
	@Autowired
	private ReservedSlot slot;
	
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
	@Override
	public void persistSlotsDetailsList(List<SlotDetails> slotDetails) throws Exception {
		try {
			slotDao.saveList(slotDetails);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

	}
	@Override
	public SlotDetails getslotDetails() throws Exception {
		try {
			SlotDetails details = slotDao.getAvailableSlot();
			return details;
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@Override
	public void bookSlot(UserDetails user, SlotDetails slotDetails) throws Exception {
		try {
			slot.setEmployeeId(user.getEmployeeId());
			slot.setBookedFlag(1);
			slot.setBookedTime(new Date());
			slot.setSlotId(slotDetails.getSlotId());
			
			slotDao.bookSlot(slot);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}

		
	}
	@Override
	public void updateSlotsDetails(SlotDetails slotDetails) throws Exception {
		
		try {
			slotDetails.setReserved(1);
			slotDao.update(slotDetails);
		}
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}

}
