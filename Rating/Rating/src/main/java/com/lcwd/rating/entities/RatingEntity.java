package com.lcwd.rating.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "TB_RP_M_RATING")
public class RatingEntity implements Serializable {
	
	
	
	
	
	
	/**@author Sharik
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RP_M_RATING_GEN")
	@SequenceGenerator(name = "SEQ_RP_M_RATING_GEN", sequenceName = "SEQ_RP_M_RATING", allocationSize = 1)
	private Long id;
	
	@Column(name = "USER_ID")
	private Long userId;
	
	@Column(name = "HOTEL_ID")
	private Long hotelId;
	
	@Column(name = "RATINGS")
	private Long ratings;
	
	@Column(name = "FEEDBACK")
	private String feedback;

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
	
	
	
	
	
	

}
