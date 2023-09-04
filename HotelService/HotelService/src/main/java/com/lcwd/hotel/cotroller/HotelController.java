package com.lcwd.hotel.cotroller;

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

import com.lcwd.hotel.models.HotelModels;
import com.lcwd.hotel.service.HotelService;


@RestController
@RequestMapping(value = "/hotel")
public class HotelController {
	
	
	@Autowired
	private HotelService hotelService;
	
	
	
	@RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HotelModels> create(@RequestBody HotelModels model)
	{
		HotelModels results = null;
		try
		{
			results = hotelService.save(model);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception occure inside create Controller method : "+e);
		}
		
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(results);
	}
	
	@RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<HotelModels>> getAll()
	{
		List<HotelModels> result = null;
		try
		{
			result = hotelService.getAll();
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception occure inside getAllRecords controller methods : "+e);
		}
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	
	
	@RequestMapping(value = "/findByIdHotel/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<HotelModels> findById(@PathVariable Long id)
	{
		HotelModels result = null;
		try
		{
			result = hotelService.findById(id);
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("Exception Occure inside findById Controller Method : "+e);
		}
		
		
		return ResponseEntity.status(HttpStatus.FOUND).body(result);
	}
	
	
}
