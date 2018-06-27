package com.example.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.User;

public interface UserService extends JpaRepository<User, Integer> {
	
	
List<User>	findByName(String name);
	

  @Query(value="select * from user mail=?1",nativeQuery=true)
  List<User> findC(String t);
   
  
  User findTop1ByMailAndPassword(String mail,String password);

}
