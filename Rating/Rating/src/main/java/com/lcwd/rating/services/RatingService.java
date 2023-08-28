package com.lcwd.rating.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lcwd.rating.entities.RatingEntity;
import com.lcwd.rating.model.RatingModel;
import com.lcwd.rating.persistance.RatingPersistance;

@Service
public class RatingService {
	
	
	
	@Autowired
	private RatingPersistance ratingPersistance;
	
	
	
	
	
	
	// find by Hotel Id
	public List<RatingModel> findByHotelId(Long hotelId)
	{
		List<RatingModel> response = new ArrayList<RatingModel>();
		try
		{
			List<RatingEntity> ratingList = ratingPersistance.findByHotelId(hotelId);
			
			for(RatingEntity entity : ratingList)
			{
				RatingModel model = new RatingModel();
				model.setId(entity.getId() != null? entity.getId() : null);
				model.setUserId(entity.getUserId() != null ? entity.getUserId() : null);
				model.setHotelId(entity.getHotelId() != null ? entity.getHotelId() : null);
				model.setRatings(entity.getRatings() != null ? entity.getRatings() : null);
				model.setFeedback(entity.getFeedback() != null ? entity.getFeedback() : null);
				
				response.add(model);
				
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occure inside find By Hotel Id service Method : "+e);
		}
		
		return response;
	}
	
	//find by UserId
	public List<RatingModel> findByUserId(Long userId)
	{
		List<RatingModel> response = new ArrayList<RatingModel>();
		try
		{
			List<RatingEntity> ratingList = ratingPersistance.findByUserId(userId);
			for(RatingEntity entity : ratingList)
			{
				RatingModel model = new RatingModel();
				model.setId(entity.getId() != null? entity.getId() : null);
				model.setUserId(entity.getUserId() != null ? entity.getUserId() : null);
				model.setHotelId(entity.getHotelId() != null ? entity.getHotelId() : null);
				model.setRatings(entity.getRatings() != null ? entity.getRatings() : null);
				model.setFeedback(entity.getFeedback() != null ? entity.getFeedback() : null);
				
				response.add(model);
				
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occure inside findByUserId service Methods : "+e);
		}
		
		return response;
	}
	
	// get All Records 
	public List<RatingModel> getAll()
	{
		List<RatingModel> response = new ArrayList<RatingModel>();
		try
		{
			List<RatingEntity> entities = ratingPersistance.getAll();
			for(RatingEntity entity : entities)
			{
				RatingModel model = new RatingModel();
				model.setId(entity.getId() != null ? entity.getId() : null);
				model.setUserId(entity.getUserId() != null ? entity.getUserId() : null);
				model.setHotelId(entity.getHotelId() != null ? entity.getHotelId() : null);
				model.setRatings(entity.getRatings() != null ? entity.getRatings() : null);
				model.setFeedback(entity.getFeedback() != null ? entity.getFeedback() : null);
				
				response.add(model);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occure inside getAll record rating service methods :+e");
		}
		return response;
	}
	//find By id rating
	public RatingModel findByID(Long id)
	{
		RatingModel response = new RatingModel();
		try
		{
			RatingEntity entity = ratingPersistance.findById(id).get();
			if(entity != null)
			{
				response.setId(entity.getId() != null ? entity.getId() : null);
				response.setUserId(entity.getUserId() != null ? entity.getUserId() : null);
				response.setHotelId(entity.getHotelId() != null ? entity.getHotelId() : null);
				response.setRatings(entity.getRatings() != null ? entity.getRatings()  : null);
				response.setFeedback(entity.getFeedback() != null ? entity.getFeedback() : null);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occure inside findById Service methods : "+e);
		}
		
		return response;
	}
	
	
	//create Rating
	public RatingModel create(RatingModel model)
	{
		
		try
		{
			RatingEntity entity = new RatingEntity();
			Optional<RatingEntity> reting = ratingPersistance.findById(model.getId());
			if(reting.isPresent())
			{
				entity.setId(model.getId() != null ? model.getId() : null );
				entity.setUserId(model.getUserId() != null ?  model.getUserId() : null);
				entity.setHotelId(model.getHotelId() != null ? model.getHotelId() : null);
				entity.setRatings(model.getRatings() != null ? model.getRatings() : null);
				entity.setFeedback(model.getFeedback() != null ? model.getFeedback() : null);
				
				ratingPersistance.save(entity);
			}
			else
			{
				entity.setId( null );
				entity.setUserId(model.getUserId() != null ?  model.getUserId() : null);
				entity.setHotelId(model.getHotelId() != null ? model.getHotelId() : null);
				entity.setRatings(model.getRatings() != null ? model.getRatings() : null);
				entity.setFeedback(model.getFeedback() != null ? model.getFeedback() : null);
				
				ratingPersistance.save(entity);
			}
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception occure inside create Rating Service Methos : "+e);
		}
		
		return model;
	}

}
