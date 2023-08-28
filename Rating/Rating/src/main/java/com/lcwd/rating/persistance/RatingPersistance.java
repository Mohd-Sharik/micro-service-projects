package com.lcwd.rating.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lcwd.rating.dao.RatingRepository;
import com.lcwd.rating.entities.RatingEntity;
import com.lcwd.rating.model.RatingModel;

@Component
@Transactional(readOnly = true)
public class RatingPersistance {
	
	
	@Autowired
	private RatingRepository ratingRepository;
	
	
	
	//find By hotel id
	public List<RatingEntity> findByHotelId(Long hotelId)
	{
		return ratingRepository.findByHotelId(hotelId);
	}
	//find by UserId
	public List<RatingEntity> findByUserId(Long userId)
	{
		return ratingRepository.findByUserId(userId);
	}
	//create rating and save
	@Transactional
	public RatingEntity save(RatingEntity entity)
	{
		return ratingRepository.save(entity);
	}
	
	// get all result by pageable;
	public List<RatingEntity> getAll(Specification<RatingEntity> speci, Pageable page)
	{
		return ratingRepository.findAll(speci, page).getContent();
	}
	//count result
	public Long count(Specification<RatingEntity> speci)
	{
		return ratingRepository.count(speci);
	}
	//find All records
	public List<RatingEntity> getAll()
	{
		return ratingRepository.findAll();
	}
	
	//find by id
	public Optional<RatingEntity> findById(Long id)
	{
		return ratingRepository.findById(id);
	}

}
