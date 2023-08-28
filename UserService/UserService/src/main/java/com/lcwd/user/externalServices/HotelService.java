package com.lcwd.user.externalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lcwd.user.models.HotelModel;
@Service
@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
	
	
	
	@GetMapping("/hotel/findByIdHotel/{hotelId}")
	HotelModel getHotel(@PathVariable Long hotelId);

}
