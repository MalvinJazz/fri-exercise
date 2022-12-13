package com.soyfri.interview.demo.dao.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.soyfri.interview.demo.dao.MealRepository;
import com.soyfri.interview.demo.models.Meal;

@Repository
public class MealRepositoryImpl implements MealRepository {
	
	@Autowired
	private MealsRestTemplate template;
	
	private final static Logger LOGGER = Logger.getLogger(MealRepository.class.getName());
	
	@Override
	public Collection<Meal> getMeals(int size, String username) {
					
		try {
			
			Collection<CompletableFuture<Meal>> futures = new ArrayList<>();
			for (int i = 0; i < size; i++) {
				futures.add(template.getMeal(username));
			}
			
			return futures
					.stream()
					.map(CompletableFuture::join)
					.collect(Collectors.toList());
			
			
		} catch (Exception e) {
			LOGGER.log(Level.SEVERE, "no meals", e);
		}
		
		return Collections.emptyList();
		
	}
	
}
