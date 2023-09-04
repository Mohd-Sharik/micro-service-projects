package com.lcwd.user.controller;


import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.ctc.wstx.shaded.msv_core.reader.State;
import com.lcwd.user.models.UserModel;
import com.lcwd.user.mservice.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;


@RestController
@RequestMapping(value = "/usrer")
public class UserController {
	
	org.slf4j.Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	
	@RequestMapping(value = "/create", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE )
	public ResponseEntity<UserModel> createUser(@RequestBody UserModel model)
	{
		UserModel response = null;
		try
		{
			response =  userService.save(model);
		}
		catch (Exception e) {
			System.out.println("Exception occure inside User Controller : "+e);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(response);
	}
	
	// find by id
	
	//int retryCount = 1;
	
	@RequestMapping(value = "/findByIdUser/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	//@CircuitBreaker(name = "hotelRatingBreaker", fallbackMethod = "ratingHotelFallBack")
	//@Retry(name = "ratingHotelsService", fallbackMethod = "ratingHotelFallBack")
	@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallBack")
	public ResponseEntity<UserModel> findById(@PathVariable Long id) throws Exception
	{
		UserModel result = null;
		//retryCount++;
		
	
			if(id == null)
				throw new Exception("Id must not be null : ");
			
			result = userService.findById(id);	
		
		return ResponseEntity.ok(result);
	}
	

	
	//fallBack method for HotelRtating
	public ResponseEntity<UserModel> ratingHotelFallBack(Long userId, Exception ex)
	{
		logger.info("fallback is Executed because service is down "+ex.getMessage());
		UserModel  user = new  UserModel();
		user.setContctNumber("*****890");
		user.setEmail("*****@gmail");
		user.setName("***Jackub");
		
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	// get all record 
	@RequestMapping	(value = "/getAllUsers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<UserModel>> getAll()
	{
		List<UserModel> result = null;
		try
		{
			result = userService.getAll();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception occure inside getAll record Controller methods : "+e);
		}
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	

}
