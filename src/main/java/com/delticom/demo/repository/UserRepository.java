package com.delticom.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.delticom.demo.model.User;

public interface UserRepository  extends JpaRepository<User, Integer>{
	
	User findByUserNameAndPassword(String un, String psw);
	
	@Query(value = "select * from user where username= :un and password = :psw", nativeQuery = true)
	User isExist(@Param("un")String un, @Param("psw")String psw);

	User findByUserName(String username);

}
