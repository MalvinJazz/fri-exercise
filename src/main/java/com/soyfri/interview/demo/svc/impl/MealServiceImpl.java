package com.soyfri.interview.demo.svc.impl;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.soyfri.interview.demo.dao.MealRepository;
import com.soyfri.interview.demo.models.Meal;
import com.soyfri.interview.demo.models.dto.MealDto;
import com.soyfri.interview.demo.svc.MealService;

@Service
public class MealServiceImpl implements MealService {

	@Autowired
	private MealRepository repository;
	
	@Override
	public Collection<MealDto> findMeals(int size) {
		
		Collection<Meal> meals = repository.getMeals(size);
		
		return meals.stream().map(m -> new MealDto(
				m.getIdMeal(),
				m.getStrMeal(),
				m.getStrCategory(),
				m.getStrArea(),
				m.getStrMealThumb(),
				m.getStrYoutube())).collect(Collectors.toList());
		
	}
	
	
}
