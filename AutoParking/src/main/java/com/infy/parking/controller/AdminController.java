package com.infy.parking.controller;

import java.nio.charset.Charset;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.infy.parking.models.AdminDetails;
import com.infy.parking.models.BuildingDetails;
import com.infy.parking.models.SlotDetails;
import com.infy.parking.models.StatusDetails;
import com.infy.parking.models.UserDetails;
import com.infy.parking.service.AdminService;
import com.infy.parking.service.Buildingservice;
import com.infy.parking.service.SlotsService;
import com.infy.parking.service.UserService;
import com.infy.parking.utilities.CSVReader;
import com.infy.parking.utilities.Encrypter;

@Controller
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	AdminService adminService;
	@Autowired
	AdminDetails admin;
	@Autowired
	private BuildingDetails buildingDetails;
	@Autowired
	private Buildingservice buildingService;
	@Autowired
	private SlotDetails slotDetails;
	@Autowired
	private SlotsService slotsService;
	@Autowired
	private UserDetails userDetails;
	@Autowired
	private UserService userService;

	private Map<String, String> loginMap = new HashMap<>();

	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	public String addBuilding(ModelMap model) {
		System.out.println("getting admin login page");
		return "adminLogin";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminLogin(ModelMap model, @RequestParam(value = "username") String uname,
			@RequestParam(value = "password") String pass, HttpServletRequest request) {
		boolean isValid = false;
		admin.setUserName(uname.trim());
		admin.setPassword(pass.trim());
		try {
			isValid = adminService.authenticateAdmin(admin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (isValid) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", "admin");
			httpSession.setAttribute("isValid", "true");
			return "adminHome";
		} else {
			model.addAttribute("errorMessage", "Username Or Password is not valid");
			return "adminLogin";
		}
	}

	// for add building view
	@RequestMapping(value = "/addBuilding", method = RequestMethod.GET)
	public String addBuilding(ModelMap model, HttpServletRequest request) {
		try {
			if (validateSession(request))
				return "addBuilding";
			else {
				return "adminLogin";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "adminLogin";
	}

	// for add building persist
	@RequestMapping(value = "/addBuildingRequest", method = RequestMethod.POST)
	public String addBuildingRequest(ModelMap model, @RequestParam("buildingId") String bId,
			@RequestParam("buildingName") String bName, HttpServletRequest request) {
		try {
			if (validateSession(request)) {
				buildingDetails.setBuildingId(bId);
				buildingDetails.setBuildingName(bName);
				buildingService.persistBuildingDetails(buildingDetails);
				model.addAttribute("message", "Building Details added successfully");
				return "addBuilding";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
		}
		return "adminLogin";
	}

	// for add slot view
	@RequestMapping(value = "/addSlot", method = RequestMethod.GET)
	public String addSlot(ModelMap model, HttpServletRequest request) {
		try {
			if (validateSession(request)) {
				List<BuildingDetails> buildingList = buildingService.getBuildingDetails();
				model.addAttribute("buildingList", buildingList);
				return "addSlot";
			}
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute("message", e.getMessage());
		}
		return "adminLogin";
	}

	// for add slot persist
	@RequestMapping(value = "/addSlotRequest", method = RequestMethod.POST)
	public String addSlotRequest(ModelMap model, @RequestParam(value = "buildingId", defaultValue = "MLPL1") String bId,
			@RequestParam(value = "floorId", defaultValue = "F00") String fId,
			@RequestParam(value = "slotId", defaultValue = "anonymous") String slotId,
			@RequestParam(value = "slotFile", required = false) MultipartFile file, HttpServletRequest request) {

		if (validateSession(request)) {
			if (file != null) {
				System.out.println("file name " + file.getName());
				CSVReader csvReader = new CSVReader();
				List<SlotDetails> list = csvReader.readSlotDetails(file);
				try {
					slotsService.persistSlotsDetailsList(list);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("buildingId " + bId);
				System.out.println("floor Id " + fId);
				System.out.println("slot ID " + slotId);
				try {
					String slotFullId = bId + "_" + fId + "_SL" + slotId;
					System.out.println(slotFullId);
					slotDetails.setBuildingId(bId);
					slotDetails.setSlotId(slotFullId);
					slotsService.persistSlotsDetails(slotDetails);

					List<BuildingDetails> buildingList = buildingService.getBuildingDetails();
					model.addAttribute("buildingList", buildingList);
					model.addAttribute("message", "Slot Details added successfully");
				} catch (Exception e) {
					e.printStackTrace();
					model.addAttribute("message", e.getMessage());
				}
			}
			return "addSlot";
		} else
			return "adminLogin";
	}

	@RequestMapping(value = "/getRegistration", method = RequestMethod.GET)
	public String getRegistration(ModelMap model, HttpServletRequest request) {
		System.out.println("Invoking REST Client for Registration Page ...");
		if (validateSession(request))
			return "Registration";
		else
			return "adminLogin";
	}

	@RequestMapping(value = "/validateRegistration", method = RequestMethod.GET)
	public String validateRegistration(HttpServletRequest request, Model model) {
		if (validateSession(request)) {
			String errorMessage = request.getParameter("error");
			String empId = request.getParameter("empId");
			String email = request.getParameter("emailAddress");
			String password = request.getParameter("password");
			System.out.println("Email : " + email);
			System.out.println("password : " + password);
			System.out.println("Error Message : '" + errorMessage + "'");

			if (errorMessage == null) {
				try {
					System.out.println("User Service : " + userService);

					userDetails.setEmail(email);
					userDetails.setEmployeeId(Integer.valueOf(empId));
					userDetails.setPassword(Encrypter.getEncryptedValue(password));
					System.out.println(userDetails.toString());
					userService.persistUsersDetails(userDetails);
					System.out.println("Person::" + userDetails);
					model.addAttribute("result", "You have successfully registered");
				} catch (Exception e) {
					e.getStackTrace();
					System.out.println(e.getStackTrace());
				}
				return "response";
			}
			return "Registration";
		} else
			return "adminLogin";
	}

	private boolean validateSession(HttpServletRequest request) {
		try {
			HttpSession hSession = request.getSession();

			if (hSession.getAttribute("user") != null && hSession.getAttribute("user").toString().equals("admin")
					&& hSession.getAttribute("isValid").toString().equals("true")) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Map<String, String> getHeaderInfo(String header) {
		if (header != null && header.startsWith("Basic")) {
			// Authorization: Basic base64credentials
			String base64Credentials = header.substring("Basic".length()).trim();
			String credentials = new String(Base64.getDecoder().decode(base64Credentials), Charset.forName("UTF-8"));
			// credentials = username:password
			System.out.println(credentials);
			final String[] values = credentials.split(":");
			Map<String, String> loginInfo = new HashMap<>();
			loginInfo.put("username", values[0]);
			loginInfo.put("password", values[1]);
			return loginInfo;
		} else
			return null;
	}

	// =======================================================JSON==============================================================

	@RequestMapping(value = "/login.json", method = RequestMethod.POST)
	public @ResponseBody AdminDetails adminLogin(ModelMap model, HttpServletRequest request,
			@RequestBody AdminDetails adminData) {
		boolean isValid = false;
		admin.setUserName(adminData.getUserName().trim());
		admin.setPassword(adminData.getPassword().trim());
		try {
			isValid = adminService.authenticateAdmin(admin);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (isValid) {
			HttpSession httpSession = request.getSession();
			httpSession.setAttribute("user", "admin");
			httpSession.setAttribute("isValid", "true");

			admin.setStatusCode("000");
			admin.setStatusMessage("Successful Login");
			return admin;
		} else {
			admin.setStatusCode("001");
			admin.setStatusMessage("Authentication Failed");
			return admin;
		}
	}

	// for add building persist
	@RequestMapping(value = "/addBuildingRequest.json", method = RequestMethod.POST)
	public @ResponseBody BuildingDetails addBuildingRequest(@RequestBody BuildingDetails building,
			HttpServletRequest request, @RequestHeader("Authorization") String header) {
		try {
			loginMap = getHeaderInfo(header);
			admin.setUserName(loginMap.get("username"));
			admin.setPassword(loginMap.get("password"));
			if (adminService.authenticateAdmin(admin) && building != null) {
				buildingService.persistBuildingDetails(building);
				building.setStatusCode("000");
				building.setStatusMessage("Building Details added successfully");
				return building;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		building.setStatusCode("001");
		building.setStatusMessage("Authentication Failed");
		return building;
	}

	@RequestMapping(value = "/validateRegistrationJ", method = RequestMethod.GET)
	public @ResponseBody UserDetails validateRegistrationJ(@RequestBody UserDetails user,@RequestHeader("Authorization") String header) {
		loginMap = getHeaderInfo(header);
		admin.setUserName(loginMap.get("username"));
		admin.setPassword(loginMap.get("password"));
		try {
			if (adminService.authenticateAdmin(admin)&& user!=null) {
				int empId = user.getEmployeeId();
				String email = user.getEmail();
				String password = user.getPassword();
				System.out.println("Email : " + email);
				System.out.println("password : " + password);

				userDetails.setEmail(email);
				userDetails.setEmployeeId(Integer.valueOf(empId));
				userDetails.setPassword(password);
				System.out.println(userDetails.toString());
				userService.persistUsersDetails(userDetails);
				System.out.println("Person::" + userDetails);
				userDetails.setPassword("");
				userDetails.setStatusCode("000");
				userDetails.setStatusMessage("You have successfully registered");
			} 
			else {
				userDetails.setStatusCode("001");
				userDetails.setStatusMessage("Authentication Failed");
			}
		}catch (Exception e) {
			e.getStackTrace();
			System.out.println(e.getStackTrace());
		}
		return userDetails;



	}

}
