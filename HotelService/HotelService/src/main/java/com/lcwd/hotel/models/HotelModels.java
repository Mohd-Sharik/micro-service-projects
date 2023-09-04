package com.lcwd.hotel.models;

import java.util.ArrayList;
import java.util.List;

public class HotelModels {
	
	
	private long id;
	private String name;
	private String location;
	private String about;
	
	private List<RatingModel> ratings;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public List<RatingModel> getRatings() {
		return ratings;
	}
	public void setRatings(List<RatingModel> ratings) {
		this.ratings = ratings;
	}
	
	
	
	
	
	

}
