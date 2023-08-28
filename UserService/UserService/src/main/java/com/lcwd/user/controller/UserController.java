package com.lcwd.user.controller;


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
import org.springframework.web.client.RestTemplate;

import com.lcwd.user.models.UserModel;
import com.lcwd.user.mservice.UserService;


@RestController
@RequestMapping(value = "/usrer")
public class UserController {
	
	
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
	@RequestMapping(value = "/findByIdUser/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserModel> findById(@PathVariable Long id)
	{
		UserModel result = null;
		
		try
		{
			if(id == null)
				throw new Exception("Id must not be null : ");
			result = userService.findById(id);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception occure inside controller findById method : "+e);
		}
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
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
