package com.soyfri.interview.demo.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.soyfri.interview.demo.models.dto.HealthDto;

@RestController
@RequestMapping("/v1/health-check")
public class HealthCheckController {

	@GetMapping
	public HealthDto checkHealth() {
		return new HealthDto("The Application is working!");
	}
	
}
