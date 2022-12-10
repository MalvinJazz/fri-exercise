package com.soyfri.interview.demo.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soyfri.interview.demo.commons.Page;
import com.soyfri.interview.demo.models.dto.MealDto;
import com.soyfri.interview.demo.svc.MealService;

@RestController
@RequestMapping("/v1/meals")
public class MealController {
	
	@Autowired
	private MealService service;

	@GetMapping
	public Page<MealDto> findMeals(@RequestParam int page, @RequestParam int count) {
		Page<MealDto> responsePage = new Page<>();
		responsePage.setCount(count);
		responsePage.setResultSet(service.findMeals(count));
		
		return responsePage;
	}
	
}
