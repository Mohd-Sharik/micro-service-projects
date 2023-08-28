package com.lcwd.hotel.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.lcwd.hotel.entities.HotelEntity;
import com.lcwd.hotel.models.HotelModels;
import com.lcwd.hotel.models.RatingModel;
import com.lcwd.hotel.repositories.Hotelrepository;

@Service
public class HotelService {
	
	
	
	@Autowired
	private Hotelrepository hotelrepository;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	
	public List<HotelModels> getAll()
	{
		List<HotelModels> response = new ArrayList<HotelModels>();
		try
		{
			List<HotelEntity> entity = hotelrepository.getAll();
			for(HotelEntity data : entity)
			{
				// here we remove Host and port instead use of Service name
				//ArrayList<RatingModel> gethotelratings =  restTemplate.getForObject("http://RATING-SERVICE/rating/findByHotelid/"+data.getId(), ArrayList.class);
				HotelModels model = new HotelModels();
				model.setId(data.getId() != null ? data.getId() : null);
				model.setName(data.getName() != null ? data.getName() : null);
				model.setLocation(data.getLocation() != null ? data.getLocation() : null);
				model.setAbout(data.getAbout() != null ? data.getAbout() : null);
				
				//model.setRatings(gethotelratings);
				
				response.add(model);
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception occure inside getAll Hotel List Service Methods : "+e);
		}
		return response;
	}
	
	
	// save Hotel data
	@Transactional
	public HotelModels save(HotelModels model)
	{
		HotelModels response = null;
		try
		{
			Long id = model.getId();
			Optional<HotelEntity> entity = hotelrepository.findById(id);
			HotelEntity entity1 = new HotelEntity();
			if(entity.isPresent())
			{
				entity1 = entity.get();
				entity1.setId(id);
				entity1.setName(model.getName() != null ? model.getName() : entity1.getName());
				entity1.setLocation(model.getLocation() != null ? model.getLocation() : entity1.getLocation());
				entity1.setAbout(model.getAbout() != null ? model.getAbout() : entity1.getAbout());
				hotelrepository.save(entity1);
				response = model;
			}
			else
			{
				//HotelEntity entity1 = new HotelEntity();
				entity1.setId(null);
				entity1.setName(model.getName() != null ? model.getName() : null);
				entity1.setLocation(model.getLocation() != null ? model.getLocation() : null);
				entity1.setAbout(model.getAbout() != null ? model.getAbout() : null);
				hotelrepository.save(entity1);
				response = model;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception occure inside create Hotel ServiceMethod : "+e);
		}
		
		return response;
	}
	
	
	// get Single Hotel By id
	public HotelModels findById(Long id)
	{
		HotelModels response = new HotelModels();
		try
		{
			// here we remove Host and port instead use of Service name
			//ArrayList<RatingModel> gethotelratings =  restTemplate.getForObject("http://RATING-SERVICE/rating/findByHotelid/"+id, ArrayList.class);
			HotelEntity entity = hotelrepository.findById(id).get();
			
			response.setId(entity.getId() != null ? entity.getId() : null);
			response.setName(entity.getName() != null ? entity.getName() : null);
			response.setLocation(entity.getLocation() != null ? entity.getLocation() : null);
			response.setAbout(entity.getAbout() != null ? entity.getAbout() : null);
			
			//response.setRatings(gethotelratings);
			
		}
		catch (Exception e) {
			// TODO: handle exception
			System.out.println("exception occure inside findById serviceClass : "+e);
		}
		
		return response;
	}

}
