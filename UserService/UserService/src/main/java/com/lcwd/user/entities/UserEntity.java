package com.lcwd.user.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.springframework.data.annotation.Transient;

@Entity
@Table(name = "TB_RP_M_USR")
public class UserEntity implements Serializable {
	
	
	
	
	/**
	 * @author Sharik
	 */
	private static final long serialVersionUID = -5854291910836215717L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_RP_M_USR_GEN" )
	@SequenceGenerator(name = "SEQ_RP_M_USR_GEN", sequenceName = "SEQ_RP_M_USR", allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name ="EMAIL")
	private String email;
	
	@Column(name = "ABOUT")
	private String about;
	
	@Column(name = "CNTCT_NUMBER")
	private String contactNumber;
	
	
//	@Transient
//	private List<RatingEntity> ratings;

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

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

//	public List<RatingEntity> getRatings() {
//		return ratings;
//	}
//
//	public void setRatings(List<RatingEntity> ratings) {
//		this.ratings = ratings;
//	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	

}
