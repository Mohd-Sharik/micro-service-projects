package com.lcwd.user.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.lcwd.user.entities.UserEntity;

@Repository
public interface UserDao extends JpaSpecificationExecutor<UserEntity> , JpaRepository<UserEntity, Long>{

}
