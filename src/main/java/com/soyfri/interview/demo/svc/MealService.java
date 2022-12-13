package com.soyfri.interview.demo.svc;

import java.util.Collection;

import com.soyfri.interview.demo.models.dto.MealDto;

public interface MealService {

	public Collection<MealDto> findMeals(int size, String user);
	
}
