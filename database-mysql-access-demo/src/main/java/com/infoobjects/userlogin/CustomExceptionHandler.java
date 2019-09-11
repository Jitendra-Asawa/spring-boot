package com.infoobjects.userlogin;

import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

// Handle Specific Exceptions only
@ControllerAdvice
public class CustomExceptionHandler {


	
	/*
	 * Returned when we reference an index not present in List
	 */
	@ExceptionHandler(IndexOutOfBoundsException.class)
	public ResponseEntity<String> handleIndexOutOfBoundsException(HttpServletRequest request) {
		return new ResponseEntity<String>("Record Doesnt Exists", HttpStatus.OK);
	}
	
	/*
	 *  
	 */
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<String> handleIllegalArgumentException(HttpServletRequest request) {
		return new ResponseEntity<String>("Wrong Value suplied", HttpStatus.OK);
	}
	
	/*
	 * This Exception is returned if a delete method does not find the ID
	 */
	@ExceptionHandler(EmptyResultDataAccessException.class)
	public ResponseEntity<String> handleEmptyResultDataAccessException(HttpServletRequest request) {
		return new ResponseEntity<String>("ID NOT found", HttpStatus.OK);
	}
	
	/*
	 *  Returned by findById() when searched id is not found 
	 */
	@ExceptionHandler(NoSuchElementException.class)
	public ResponseEntity<String> handleNoSuchElementException(HttpServletRequest request) {
		return new ResponseEntity<String>("Id Not Found", HttpStatus.OK);
	}
	
	/*
	 * Unhandled Exception
	 */
	@RequestMapping("/error")
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(HttpServletRequest request) {
		System.out.println("response error");
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		Exception exception = (Exception) request.getAttribute("javax.servlet.error.exception");
		String bodyString = String.format(
				"<html><body><h2>Error Page</h2><div>Status code: <b>%s</b></div>"
						+ "<div>Exception Message: <b>%s</b></div><body></html>",
				statusCode, exception == null ? "N/A" : exception.getMessage());
		System.out.println(exception);
		return new ResponseEntity<String>(bodyString, HttpStatus.OK);
	}
	
//	@Override
//	public String getErrorPath() {
//		System.out.println("error handler");
//		return "/error";
//	}
}