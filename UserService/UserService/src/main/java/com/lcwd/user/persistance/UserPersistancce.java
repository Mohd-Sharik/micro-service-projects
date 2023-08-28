package com.lcwd.user.persistance;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.lcwd.user.dao.UserDao;
import com.lcwd.user.entities.UserEntity;

@Component
@Transactional(readOnly = true)
public class UserPersistancce {
	
	
	@Autowired
	 private UserDao userdao;
	
	//extract user by id from database;
	public Optional<UserEntity> findById(Long id)
	{
		return userdao.findById(id);
	}
	
	//save user into database
	@Transactional   //we must use this annotation otherwise it will not allow store data in to database
	public UserEntity save(UserEntity entity)
	{
		return userdao.save(entity);
	}
	
	
	//count user
	public Long count(Specification<UserEntity> speci)
	{
		return userdao.count(speci);
	}
	
	// extract alll user's from database
	public List<UserEntity> getAll()
	{
		return userdao.findAll();
	}
	
	
	public List<UserEntity> getAll(Specification<UserEntity> speci,Pageable page)
	{
		return userdao.findAll(speci, page).getContent();
	}
	
	
	
	

}
