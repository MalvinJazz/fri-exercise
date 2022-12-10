package com.soyfri.interview.demo.models;

import java.io.Serializable;

public class Meal implements Serializable {
	
	private static final long serialVersionUID = -1133750889056300128L;
	
	private int idMeal;
	private String strMeal;
	private String strCategory;
	private String strArea;
	private String strMealThumb;
	private String strYoutube;
	
	public Meal() {
	}

	public Meal(int idMeal, String strMeal, String strCategory, String strArea, String strMealThumb,
			String strYoutube) {
		super();
		this.idMeal = idMeal;
		this.strMeal = strMeal;
		this.strCategory = strCategory;
		this.strArea = strArea;
		this.strMealThumb = strMealThumb;
		this.strYoutube = strYoutube;
	}

	public int getIdMeal() {
		return idMeal;
	}

	public void setIdMeal(int idMeal) {
		this.idMeal = idMeal;
	}

	public String getStrMeal() {
		return strMeal;
	}

	public void setStrMeal(String strMeal) {
		this.strMeal = strMeal;
	}

	public String getStrCategory() {
		return strCategory;
	}

	public void setStrCategory(String strCategory) {
		this.strCategory = strCategory;
	}

	public String getStrArea() {
		return strArea;
	}

	public void setStrArea(String strArea) {
		this.strArea = strArea;
	}

	public String getStrMealThumb() {
		return strMealThumb;
	}

	public void setStrMealThumb(String strMealThumb) {
		this.strMealThumb = strMealThumb;
	}

	public String getStrYoutube() {
		return strYoutube;
	}

	public void setStrYoutube(String strYoutube) {
		this.strYoutube = strYoutube;
	}
	
}
