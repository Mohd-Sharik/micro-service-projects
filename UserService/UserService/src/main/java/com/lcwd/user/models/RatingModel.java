package com.lcwd.user.models;

import java.util.List;

public class RatingModel {
	
	
	    private Long id;
		private Long userId;
		private Long hotelId;
		private Long ratings;
		private String feedback;
		
		private List<HotelModel> hotels;
		private HotelModel hotel;
		
		
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public Long getUserId() {
			return userId;
		}
		public void setUserId(Long userId) {
			this.userId = userId;
		}
		public Long getHotelId() {
			return hotelId;
		}
		public void setHotelId(Long hotelId) {
			this.hotelId = hotelId;
		}
		public Long getRatings() {
			return ratings;
		}
		public void setRatings(Long ratings) {
			this.ratings = ratings;
		}
		public String getFeedback() {
			return feedback;
		}
		public void setFeedback(String feedback) {
			this.feedback = feedback;
		}
		public List<HotelModel> getHotels() {
			return hotels;
		}
		public void setHotels(List<HotelModel> hotels) {
			this.hotels = hotels;
		}
		public HotelModel getHotel() {
			return hotel;
		}
		public void setHotel(HotelModel hotel) {
			this.hotel = hotel;
		}
		
		

}
