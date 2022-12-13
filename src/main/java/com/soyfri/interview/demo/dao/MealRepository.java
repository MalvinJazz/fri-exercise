package com.soyfri.interview.demo.dao;

import java.util.Collection;

import com.soyfri.interview.demo.models.Meal;

public interface MealRepository {

	public Collection<Meal> getMeals(int size, String username);
	
}
