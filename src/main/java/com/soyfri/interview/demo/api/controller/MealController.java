package com.soyfri.interview.demo.api.controller;

import java.security.Principal;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.soyfri.interview.demo.commons.CacheStore;
import com.soyfri.interview.demo.commons.Page;
import com.soyfri.interview.demo.models.dto.MealDto;
import com.soyfri.interview.demo.svc.MealService;

@RestController
@RequestMapping("public/v1/meals")
public class MealController {
	
	@Autowired
	private MealService service;

	private final static CacheStore<String, Page<MealDto>> cache = new CacheStore<>(100000, 1);
	private final static String CACHE_KEY_FORMAT = "USER(%s) PAGE(%d)";
	
	private final static Logger LOGGER = Logger.getLogger(MealController.class.getName());

	@GetMapping
	public Page<MealDto> findMeals(@RequestParam int page, @RequestParam int count, @CurrentSecurityContext SecurityContext context) {
		
		LOGGER.info(context.getAuthentication().toString());
		final String username = context.getAuthentication().getName();
		
		final String key = String.format(CACHE_KEY_FORMAT, username, page);
		
		Optional<Page<MealDto>> mealOptional = cache.get(key);
		
		if (mealOptional.isPresent()) {
			return mealOptional.get();
		}
		
		Page<MealDto> responsePage = new Page<>();
		responsePage.setCount(count);
		responsePage.setCurrentPage(page);
		responsePage.setNextPage(page);
		responsePage.setPreviousPage(page);
		responsePage.setResultSet(service.findMeals(count, username));
		responsePage.setCurrentUser(username);
		
		cache.add(key, responsePage);
		
		return responsePage;
	}
	
}
