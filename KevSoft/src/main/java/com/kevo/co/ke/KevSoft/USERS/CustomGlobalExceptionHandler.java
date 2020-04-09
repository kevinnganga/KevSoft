package com.kevo.co.ke.KevSoft.USERS;

import java.util.Date;
import java.util.Set;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails customErrorDetails=new CustomErrorDetails(new Date(),"Method from MethodArgumentNotValid Exception in Global Error Handling",ex.getMessage());
		
		return new ResponseEntity<>(customErrorDetails,HttpStatus.BAD_REQUEST);
	}
	
	
	//HttpRequestMethodNotSupportedException
	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(
			HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
			
		CustomErrorDetails customErrorDetails=new CustomErrorDetails(new Date(),"Method from HttpRequestMethodNotSupportedException in Global Error Handling-Method Not Allowed",ex.getMessage());
		return new ResponseEntity<>(customErrorDetails,HttpStatus.METHOD_NOT_ALLOWED);
		
	}
	
	//UsernameNotFoundException
	@ExceptionHandler(UsernameNotFoundException.class)
	public final ResponseEntity<Object>handleUserNameNotFoundException(UsernameNotFoundException ex,WebRequest request){
		
		CustomErrorDetails customErrorDetails=new CustomErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(customErrorDetails,HttpStatus.NOT_FOUND);
	}
	
	//ConstraintViolationException
	@ExceptionHandler(ConstraintViolationException.class)
	public final ResponseEntity<Object> handleConstraintsViolationException(ConstraintViolationException ex,WebRequest request){
		
		CustomErrorDetails customErrorDetails=new CustomErrorDetails(new Date(),ex.getMessage(),request.getDescription(false));
		return new ResponseEntity<>(customErrorDetails,HttpStatus.BAD_REQUEST);
	}
}
