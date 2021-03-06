package com.infy.parking.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/client")
public class SendRequestController {

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

}