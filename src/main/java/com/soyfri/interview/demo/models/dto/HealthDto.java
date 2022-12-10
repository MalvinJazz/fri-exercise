package com.soyfri.interview.demo.models.dto;

import java.io.Serializable;

public class HealthDto implements Serializable{

	private static final long serialVersionUID = 6747694946042470903L;

	private String message;
	
	public HealthDto(String message) {
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
