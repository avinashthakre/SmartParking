package com.sample.common.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sample.common.RestInvoker.RestInvokerImpl;

@Controller
@RequestMapping("/client")
public class SendRequestController {

	RestInvokerImpl invoker = new RestInvokerImpl();

	@RequestMapping(value = "/getClient", method = RequestMethod.GET)
	public String getClient(ModelMap model) {
		System.out.println("Invoking REST Client ...");
		return "RESTClient";
	}

	@RequestMapping(value = "/sendrequest", method = RequestMethod.GET)
	public String sendRequest(HttpServletRequest request, Model model) {
		
		HttpHeaders headers = new HttpHeaders();
		String contentType = request.getParameter("contentType");
		String requestBody = request.getParameter("bodyText");
		System.out.println("RequestBody : " + requestBody);
		
		if(contentType.equalsIgnoreCase("json")) {
			headers.setContentType(MediaType.APPLICATION_JSON);
		}else if(contentType.equalsIgnoreCase("xml"))
			headers.setContentType(MediaType.APPLICATION_XML);
		
        ResponseEntity<String> response = null;
       // headers.setContentType(MediaType.APPLICATION_JSON);
		String requestType = request.getParameter("branch");
		System.out.println("RequestType : " + requestType);
		if(requestType.equalsIgnoreCase("GET"))
			response = invoker.getRequestInvoker(String.class, request, headers);
		else if(requestType.equalsIgnoreCase("POST"))
			response = invoker.postRequestInvoker(String.class, request, headers);
		else if(requestType.equalsIgnoreCase("DELETE"))
			response = invoker.deleteRequestInvoker(String.class, request, headers);
		
		System.out.println(response.getBody());
		
		model.addAttribute("headers",response.getHeaders().toString());
		model.addAttribute("response", response.getBody());
		return "list";
	}

}