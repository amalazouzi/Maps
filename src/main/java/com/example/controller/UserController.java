package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.model.User;
import com.example.service.UserService;

@RestController

public class UserController {


	@Autowired
	UserService userService;
	
	@GetMapping("/users")
	public List<User> listusers(){
		
		return userService.findAll();
	}
	
	
	
	@PostMapping("/adduserr")
	public User create(String name,String mail,String password,String num_tel) {
		
		
		User u=new User();
		u.setName(name);
		u.setMail(mail);
		u.setPassword(password);
		u.setNum_tel(num_tel);
		
		userService.saveAndFlush(u);
		
		return u;
	}
	
	@GetMapping("/deleteuserr/{id}")
	public MyResponse delete (@PathVariable("id")int id) {
		
		
		MyResponse res=new MyResponse();
		res.setSuccess(false);
		res.setMessage("user not deleted!!");
		
		if(userService.existsById(id)) {
		
			userService.deleteById(id);
			res.setSuccess(true);
			res.setMessage("user deleted successfully!!");
		}
		return res;
		}
		
	
	
	@PostMapping("/updateuser")
	public User update(int id,String name,String mail,String password,String num_tel){
		
		
		User u=new User();
		u.setId(id);
		u.setName(name);
		u.setMail(mail);
		u.setPassword(password);
		u.setNum_tel(num_tel);
		userService.saveAndFlush(u);
		
		return u;
	}

	@PostMapping("/finduser")
	public User listuser(String mail,String password)
	{
		
	
		return  userService.findTop1ByMailAndPassword(mail,password);			
	}
	
}
