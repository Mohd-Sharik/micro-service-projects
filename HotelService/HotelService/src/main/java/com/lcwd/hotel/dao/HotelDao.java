package com.lcwd.hotel.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.lcwd.hotel.entities.HotelEntity;

@Repository
public interface HotelDao extends JpaSpecificationExecutor<HotelEntity>,JpaRepository<HotelEntity, Long> {

}
