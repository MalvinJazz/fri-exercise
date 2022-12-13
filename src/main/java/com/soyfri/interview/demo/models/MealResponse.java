package com.soyfri.interview.demo.models;

import java.io.Serializable;
import java.util.stream.Stream;

public class MealResponse implements Serializable {

	private static final long serialVersionUID = -6716463461512565890L;

	private Meal[] meals;
	
	public MealResponse() {
	}

	public MealResponse(Meal[] meals) {
		super();
		this.meals = meals;
	}

	public Meal[] getMeals() {
		return meals;
	}

	public void setMeals(Meal[] meals) {
		this.meals = meals;
	}
	
	public Meal getMeal() {
		
		return Stream.of(this.meals).findAny().get();
		
	}
	
}
