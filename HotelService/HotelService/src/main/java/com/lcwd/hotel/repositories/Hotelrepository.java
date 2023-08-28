package com.lcwd.hotel.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lcwd.hotel.dao.HotelDao;
import com.lcwd.hotel.entities.HotelEntity;

@Component
@Transactional(readOnly = true)
public class Hotelrepository {
	
	
	@Autowired
	private HotelDao hoteldao;
	
	
	public Optional<HotelEntity> findById(Long id)
	{
		return hoteldao.findById(id);
	}
	

	public Long count(Specification<HotelEntity> speci)
	{
		return hoteldao.count(speci);
	}
	
	public HotelEntity save(HotelEntity entity)
	{
		return hoteldao.save(entity);
	}
	
	public List<HotelEntity> getAll()
	{
		return hoteldao.findAll();
	}
	
	
	public List<HotelEntity> getAll(Specification<HotelEntity> speci, Pageable page)
	{
		return hoteldao.findAll(speci, page).getContent();
	}


}
