package com.sample.common.RestInvoker;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestInvokerImpl implements RestInvoker {
	RestTemplate restTemplate = new RestTemplate();

	@Override
	public <T> ResponseEntity<T> getRequestInvoker(Class<T> responseType, HttpServletRequest request,
			HttpHeaders headers) {
		HttpEntity<String> entity = new HttpEntity<String>("Hello Rest!", headers);

		String requestURI = request.getParameter("requestURI");
		System.out.println("Request URI is " + requestURI);
		ResponseEntity<T> response = restTemplate.exchange(requestURI, HttpMethod.GET, entity, responseType, 100);
		System.out.println("Response is: " + response.getBody());

		return response;

	}
	
	@Override
	public <T> ResponseEntity<T> postRequestInvoker(Class<T> responseType, HttpServletRequest request, HttpHeaders headers) {
		String requestURI = request.getParameter("requestURI");
		System.out.println("Request URI is " + requestURI);

		HttpEntity<String> entity = new HttpEntity<String>(request.getParameter("bodyText"),headers);
		ResponseEntity<T> response = restTemplate.postForEntity( requestURI, entity , responseType );
		
		return response;
	}

	@Override
	public <T> ResponseEntity<T> deleteRequestInvoker(Class<T> responseType, HttpServletRequest request,
			HttpHeaders headers) {
		String requestURI = request.getParameter("requestURI");
		System.out.println("Request URI is " + requestURI);
		HttpEntity<String> entity = new HttpEntity<String>("Hello Rest!", headers);

		ResponseEntity<T> response = restTemplate.exchange(requestURI, HttpMethod.DELETE, entity, responseType, 100);
		return response;
	}
	


	

	

}
