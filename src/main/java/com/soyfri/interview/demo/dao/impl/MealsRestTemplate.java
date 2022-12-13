package com.soyfri.interview.demo.dao.impl;

import java.net.URI;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Logger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.soyfri.interview.demo.models.Meal;
import com.soyfri.interview.demo.models.MealResponse;
import com.soyfri.interview.demo.util.UserMealValidator;

@Component
public class MealsRestTemplate {
	
	private final RestTemplate restTemplate;
	private final static Logger LOGGER = Logger.getLogger(MealsRestTemplate.class.getName());
	private final static UserMealValidator validator = new UserMealValidator();
	
	public MealsRestTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}

	@Async("restTaskExecutor")
	public CompletableFuture<Meal> getMeal(String username) throws Exception {
		
		boolean isValidMeal = false;
		Meal meal = new Meal();
		
		do {
			URI uri = new URI("https", "www.themealdb.com", "/api/json/v1/1/random.php", "");
			
			ResponseEntity<MealResponse> response = restTemplate.getForEntity(
					uri, MealResponse.class);
			
			if (response.getStatusCode().equals(HttpStatus.OK)) {
				
				meal = response.getBody().getMeal();
				
				LOGGER.info(Thread.currentThread().getName() + ": Meal Lookup... waiting...");
				LOGGER.info(Thread.currentThread().getName() + ": " + meal.getStrMeal());
				
				isValidMeal = validator.validate(username, meal);
				
			} else {
				throw new HttpClientErrorException(response.getStatusCode());
			}
			
		} while (!isValidMeal);
		
		return CompletableFuture.completedFuture(meal);
		
	}
	
}
