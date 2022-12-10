package com.soyfri.interview.demo.models.dto;

import java.io.Serializable;

public class MealDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3149176691058718630L;
	
	private int id;
	private String name;
	private String category;
	private String origin;
	private String image;
	private String youtube;
	
	public MealDto() {
	}

	public MealDto(int id, String name, String category, String origin, String image, String youtube) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.origin = origin;
		this.image = image;
		this.youtube = youtube;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getOrigin() {
		return origin;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}
	
}
