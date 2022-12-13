package com.soyfri.interview.demo.util;

import com.soyfri.interview.demo.models.Meal;

public interface MealValidator {

	public boolean validate(String currentUser, Meal meal);
	
}
