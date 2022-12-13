package com.soyfri.interview.demo.util;

import java.util.Optional;
import java.util.logging.Logger;

import com.soyfri.interview.demo.commons.CacheStore;
import com.soyfri.interview.demo.models.Meal;

public class UserMealValidator implements MealValidator {

	private final static CacheStore<String, Meal> mealCache = new CacheStore<>(100000, 1);
	private final static Logger LOGGER = Logger.getLogger(UserMealValidator.class.getName());
	
	@Override
	public boolean validate(String currentUser, Meal meal) {
		
		String key = String.format("%s_%d", currentUser, meal.getIdMeal());
		Optional<Meal> optional = mealCache.get(key);

		if (optional.isPresent()) {
			return false;
		}
		
		mealCache.add(key, meal);
		
		return true;
	}

}
