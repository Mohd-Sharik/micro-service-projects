package com.lcwd.rating.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.lcwd.rating.entities.RatingEntity;

@Repository
public interface RatingRepository extends JpaSpecificationExecutor<RatingEntity>, JpaRepository<RatingEntity, Long> {
	
	
	List<RatingEntity> findByUserId(Long userId);
	List<RatingEntity> findByHotelId(Long hotelId);

}
