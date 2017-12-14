package com.infy.parking.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.infy.parking.dao.UserDao;
import com.infy.parking.models.BuildingDetails;
import com.infy.parking.models.SlotDetails;
import com.infy.parking.models.UserDetails;
import com.infy.parking.service.Buildingservice;
import com.infy.parking.service.SlotsService;
import com.infy.parking.service.UserService;
import com.infy.parking.utilities.CSVReader;
import com.infy.parking.utilities.Encrypter;


//@RestController
@Controller
@RequestMapping("/client")
public class SendRequestController {

	@Autowired
	private UserDetails userDetails;
	@Autowired
	private UserService userService;
	@Autowired
	private SlotsService slotService;
	@Autowired
	private SlotDetails slotDetails;

	@RequestMapping(value = "/getClient", method = RequestMethod.GET)
	public String getClient(ModelMap model) {
		System.out.println("Invoking REST Client ...");
		return "Home";
	}

	//Authenticate user
	//fetch empty Slot
	//book available slot
	@RequestMapping(value = "/sendrequest", method = RequestMethod.POST )
	public String reserveParkingSlot(HttpServletRequest request, Model model,@RequestParam("empId") String empId,@RequestParam(value="password") String pass) {
		try {
			int employeeId = Integer.parseInt(empId);
			userDetails.setEmployeeId(employeeId);
			userDetails.setPassword(Encrypter.getEncryptedValue(pass));
			if(userService.validateUser(userDetails)) {
				SlotDetails slot = slotService.getslotDetails();
				System.out.println(slot);
				slotService.bookSlot(userDetails, slot);
				slotService.updateSlotsDetails(slot);

				String buildingId =slot.getSlotId().split("_")[0];
				String floorId =slot.getSlotId().split("_")[1];
				String slotId =slot.getSlotId().split("_")[2];

				model.addAttribute("buildingId", buildingId);
				model.addAttribute("floorId", floorId);
				model.addAttribute("slotId", slotId);
				model.addAttribute("result", "SUCCESS");
				return "response";
			}
			else {
				model.addAttribute("result", "FAILED");
				return "response";
			}
		}
		catch (Exception e) {
			e.printStackTrace();

		}
		return "response";
	}


//	============================================================JSON================================================
	
	@RequestMapping(value = "/sendrequest.json", method = RequestMethod.POST )
	public @ResponseBody SlotDetails reserveParkingSlotJ(@RequestBody UserDetails user) {
		try {
			int employeeId = user.getEmployeeId();
			userDetails.setEmployeeId(employeeId);
			userDetails.setPassword(Encrypter.getEncryptedValue(user.getPassword()));
			if(userService.validateUser(userDetails)) {
				SlotDetails slot = slotService.getslotDetails();
				System.out.println(slot);
				slotService.bookSlot(userDetails, slot);
				slotService.updateSlotsDetails(slot);

				slotDetails.setBuildingId(slot.getBuildingId());
				slotDetails.setSlotId(slot.getSlotId());
				slotDetails.setStatusCode("000");
				slotDetails.setStatusMessage("Successful slot reservation");
			}
			else {
				slotDetails.setBuildingId("");
				slotDetails.setSlotId("");
				slotDetails.setStatusCode("002");
				slotDetails.setStatusMessage("Slot reservation failed");
			}
		}
		catch (Exception e) {
			e.printStackTrace();

		}
		return slotDetails;
	}



}