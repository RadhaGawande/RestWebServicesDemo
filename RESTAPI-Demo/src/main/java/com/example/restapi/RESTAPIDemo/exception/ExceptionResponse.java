package com.example.restapi.RESTAPIDemo.exception;

import java.util.Date;


public class ExceptionResponse {
  private Date timestamp; //timestamp
  private String message;	//message
 private String details;	//detail
public ExceptionResponse(Date timestamp, String message, String details) {
	super();
	this.timestamp = timestamp;
	this.message = message;
	this.details = details;
}

public Date getTimestamp() {
	return timestamp;
}
public String getMessage() {
	return message;
}
public String getDetails() {
	return details;
}

 
}
