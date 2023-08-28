package com.lcwd.user.mservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.ILoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.entities.UserEntity;
import com.lcwd.user.externalServices.HotelService;
import com.lcwd.user.models.HotelModel;
import com.lcwd.user.models.RatingModel;
import com.lcwd.user.models.UserModel;
import com.lcwd.user.persistance.UserPersistancce;

import ch.qos.logback.classic.Logger;

@Service
public class UserService {
	
	
	
	@Autowired
	private UserPersistancce userPersistance;
	
	
	// communication other microservice here
	@Autowired
	private RestTemplate restTemplate;
	

	@Autowired
	private HotelService hotelService;
	
	
	
	
	public UserModel getUserById(Long id)
	{
		UserModel response = new UserModel();
		try
		{
			UserEntity entity = userPersistance.findById(id).get();
			response.setId(entity.getId() != null ? entity.getId() : null);
			response.setName(entity.getName() != null ? entity.getName() : null);
			response.setEmail(entity.getEmail()!= null ? entity.getEmail() : null);
			response.setContctNumber(entity.getContactNumber() != null ? entity.getContactNumber() : null);
			response.setAbout(entity.getAbout() != null ? entity.getAbout() : null);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occure inside getUserWithRating service methods : "+e);
		}
		
		
		return response;
	}
	
	// create user and save data in to database
	public UserModel save(UserModel model)
	{
		UserModel userModel = null;
		try
		{
			UserEntity entity = new UserEntity();
			entity.setId(null);
			entity.setName(model.getName() != null ?  model.getName() : null);
			entity.setEmail(model.getEmail() != null ? model.getEmail() : null);
			entity.setAbout(model.getAbout() != null ? model.getAbout() : null);
			entity.setContactNumber(model.getContctNumber() != null ? model.getContctNumber() : null);
			 userPersistance.save(entity);
			 userModel = model;
		}
		catch (Exception e) {
			
			System.out.println("Exception occure inside UserService add method : "+e);
		}
		
		return userModel;
	}
	
	//get user by id
	public UserModel findById(Long id)
	{
		UserModel response = new UserModel();
		   
		try
		{
			UserEntity entity = userPersistance.findById(id).get();
			// here call another microservices to get result
			// here we remove Host and port instead use of Service name
		RatingModel[]  ratings =	restTemplate.getForObject("http://RATING-SERVICE/rating/findByUserId/"+id, RatingModel[].class);
		List<RatingModel> ratList = Arrays.stream(ratings).toList();
//		List<HotelModel> listHotel = new ArrayList<>();
//		for(RatingModel rate : ratings)
//		{
//			// here we calling FeignClient interface method to call Hotel Service
//			HotelModel hotel = hotelService.getHotel(rate.getHotelId());
//			listHotel.add(hotel);
//		}
//		
		List<RatingModel> ratingList = ratList.stream()
			    .map(input -> {
			        HotelModel hotel = hotelService.getHotel(input.getHotelId());
			        input.setHotel(hotel);
			        return input;
			    })
			    .collect(Collectors.toList());

		
			response.setId(entity.getId()!= null ? entity.getId() : null);
			response.setContctNumber(entity.getContactNumber() != null ? entity.getContactNumber() : null);
			response.setAbout(entity.getAbout() != null ? entity.getAbout() : null);
			response.setName(entity.getName() != null ? entity.getName() : null);
			response.setEmail(entity.getEmail() != null ? entity.getEmail() : null);
			response.setRatings(ratingList);
			//response.setHotels(ratingList);
			
			
		}
		catch (Exception e) {
			System.out.println("exception occure inside findById service method : "+e);
		}
		
		return response;
	}
	
	// getAll records from database
	public List<UserModel> getAll()
	{
		List<UserModel> response = new ArrayList<UserModel>();
		try
		{
			List<UserEntity> entity = new ArrayList<>();
			entity = userPersistance.getAll();
			for(UserEntity data : entity)
			{
				// call rating microservices using RestTemplate interface 
				// here we remove Host and port instead use of Service name
				ArrayList<RatingModel>  ratings =	restTemplate.getForObject("http://RATING-SERVICE/rating/findByUserId/"+data.getId(), ArrayList.class);
				UserModel model = new UserModel();
				model.setId(data.getId());
				model.setName(data.getName());
				model.setEmail(data.getEmail());
				model.setAbout(data.getAbout());
				model.setContctNumber(data.getContactNumber());
				model.setRatings(ratings);
				
				response.add(model);
				
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception occure inside getAllRecord service method : "+e);
		}
		return response;
	}
	
	
	
	
	
	
	
	
}
