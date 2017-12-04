package com.sample.common.RestInvoker;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;



public interface RestInvoker {
	
	public  <T>ResponseEntity<T> getRequestInvoker(Class<T> responseType,HttpServletRequest request,HttpHeaders headers);
	
	public  <T>ResponseEntity<T> deleteRequestInvoker(Class<T> responseType,HttpServletRequest request, HttpHeaders headers);
	
	public  <T>ResponseEntity<T> postRequestInvoker(Class<T> responseType,HttpServletRequest request, HttpHeaders headers);
	
}
