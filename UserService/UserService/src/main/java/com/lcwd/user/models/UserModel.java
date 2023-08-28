package com.lcwd.user.models;

import java.util.List;



import com.lcwd.user.entities.RatingEntity;

public class UserModel {
	
	
	private Long id;
	private String name;
	private String email;
	private String about;
	private String contctNumber;
	
	
	private List<RatingModel> ratings;
	
	private List<HotelModel> hotels;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	public String getContctNumber() {
		return contctNumber;
	}
	public void setContctNumber(String contctNumber) {
		this.contctNumber = contctNumber;
	}
	public List<RatingModel> getRatings() {
		return ratings;
	}
	public void setRatings(List<RatingModel> ratings) {
		this.ratings = ratings;
	}
	public List<HotelModel> getHotels() {
		return hotels;
	}
	public void setHotels(List<HotelModel> hotels) {
		this.hotels = hotels;
	}

	
	
	

}
