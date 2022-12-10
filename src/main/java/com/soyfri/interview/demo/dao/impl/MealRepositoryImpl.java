package com.soyfri.interview.demo.dao.impl;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.soyfri.interview.demo.commons.CacheStore;
import com.soyfri.interview.demo.dao.MealRepository;
import com.soyfri.interview.demo.models.Meal;
import com.soyfri.interview.demo.models.MealResponse;

@Repository
public class MealRepositoryImpl implements MealRepository{

	@Autowired
	private RestTemplate restTemplate;
	
	Gson gson = new GsonBuilder().create();
	
	private final static Logger LOGGER = Logger.getLogger(MealRepository.class.getName());
	
	private CacheStore<String, Meal> mealCache = new CacheStore<>(100000, 1);
	
	@Override
	public Collection<Meal> getMeals(int size) {
		
		Map<Integer, Meal> mealsMap = new HashMap<>();
		
		while (mealsMap.size() < size) {
			
			try {				
				Meal meal = getMeal();
				LOGGER.info(meal.getStrMeal());
				
				mealsMap.put(meal.getIdMeal(), meal);
			} catch (Exception e) {
				LOGGER.log(Level.SEVERE, "no meals", e);
			}
			
			
		}
		
		return mealsMap.values();
		
	}
	
	private Meal getMeal() throws Exception {
		
		URI uri = new URI("https", "www.themealdb.com", "/api/json/v1/1/random.php", "");
		
		ResponseEntity<MealResponse> response = restTemplate.getForEntity(
				uri, MealResponse.class);
		
		
		if (response.getStatusCode().equals(HttpStatus.OK)) {			
			Meal[] meals = response.getBody().getMeals();
			return Stream.of(meals).findAny().get();
		} else {
			throw new Exception("no meals");
		}
		
	}
	
}
