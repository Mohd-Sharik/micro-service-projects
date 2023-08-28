package com.lcwd.rating.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lcwd.rating.model.RatingModel;
import com.lcwd.rating.services.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	
	@Autowired
	private RatingService ratingService;
	
	
	
	// find by Hotel Id
	@RequestMapping(value = "/findByHotelid/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RatingModel>>  findByHotelId(@PathVariable Long id)
	{
		List<RatingModel> result = null;
		
		try
		{
			if(id == null)
				throw new Exception("HotelId must not be null ");
				result = ratingService.findByHotelId(id);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occure inside find By Hotel Id Controller : "+e);
		}
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	
	// findByIserId
	@RequestMapping(value = "/findByUserId/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RatingModel>> findByUserId(@PathVariable Long id)
	{
		List<RatingModel> result = null;
		
		
		try
		{
			if(id == null)
				throw new Exception("UserId must not be null ");
			result = ratingService.findByUserId(id);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occure inside findById Controller : "+e);
		}
		
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	
	
	// get all ratings
	@RequestMapping(value = "/getallrating", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<RatingModel>>  getAll()
	{ 
		List<RatingModel> result = null;
		try
		{
			result = ratingService.getAll();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occure Inside getAll records service Methods : "+e);
		}
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	// find By id rating
	@RequestMapping(value = "/findByIdRating/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RatingModel> findById(@PathVariable Long id)
	{
		RatingModel result =  null;
		
		
		try
		{
			if(id == null)
				throw new Exception("id Must not be null");
			result = ratingService.findByID(id);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occure inside findByIdRating controller : "+e);
		}
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	// create and update ratings
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RatingModel> create(@RequestBody RatingModel model)
	{
		RatingModel result = null;
		try
		{
			result = ratingService.create(model);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occure inside create Rating Controller Method : "+e);
		}
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(result);
	}

}
