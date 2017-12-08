package com.infy.parking.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infy.parking.models.BuildingDetails;
import com.infy.parking.service.Buildingservice;



@Controller
@RequestMapping("/client")
public class SendRequestController {


	@Autowired
	private BuildingDetails buildingDetails;
	@Autowired
	private Buildingservice buildingService;




	@RequestMapping(value = "/getClient", method = RequestMethod.GET)
	public String getClient(ModelMap model) {
		System.out.println("Invoking REST Client ...");
		return "Home";
	}

	@RequestMapping(value = "/sendrequest", method = RequestMethod.GET )
	public String sendRequest(HttpServletRequest request, Model model) {



		model.addAttribute("message","Please wait, parking slot is getting book...");
		return "list";
	}

	//for add building view
	@RequestMapping(value = "/addBuilding", method = RequestMethod.GET)
	public String addBuilding(ModelMap model) {
		System.out.println("Invoking REST Client ...");
		return "addBuilding";
	}

	
	//for add building persist
	@RequestMapping(value = "/addBuildingRequest", method = RequestMethod.POST)
	public String addBuildingRequest(ModelMap model,@RequestParam("buildingId") String bId,@RequestParam("buildingName") String bName) {
		System.out.println("buildingId "+bId);
		System.out.println("buildingName "+bName);
		try {
			buildingDetails.setBuildingId(bId);
			buildingDetails.setBuildingName(bName);
			buildingService.persistBuildingDetails(buildingDetails);
			model.addAttribute("message","Building Details added successfully");
		}
		catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message",e.getMessage());
		}
		
		return "addBuilding";
	}


}