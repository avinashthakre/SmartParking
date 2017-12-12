package com.infy.parking.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.infy.parking.models.AdminDetails;
import com.infy.parking.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	AdminDetails admin;
	
	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	public String addBuilding(ModelMap model) {
		System.out.println("getting admin login page");
		return "adminLogin";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminLogin(ModelMap model,@RequestParam(value="username") String uname,@RequestParam(value="password") String pass,HttpServletRequest request) {
		boolean isValid = false;
		admin.setUserName(uname.trim());
		admin.setPassword(pass.trim());
		
		try {
			isValid = adminService.authenticateAdmin(admin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		if(isValid) {
			HttpSession httpSession =  request.getSession();
			httpSession.setAttribute("user", "admin");
			httpSession.setAttribute("isValid", "true");
			
			return "adminHome";
		}
		else {
			model.addAttribute("errorMessage", "Username Or Password is not valid");
			return "adminLogin";
		}
	}
}
