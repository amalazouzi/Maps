package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Categorie;
import com.example.service.CategorieService;

@RestController
public class CategorieController {

	@Autowired
	CategorieService CategorieService;
	
	@GetMapping("/categories")
    public List<Categorie> listcategories(){
		
		return CategorieService.findAll();
	}
	
	@PostMapping("/addcategorie")
	public Categorie create(String name,boolean work_time) {
		
		
		Categorie c=new Categorie();
		c.setName(name);
		c.setWork_time(work_time);
	

		CategorieService.saveAndFlush(c);
		
		return c;
	}
	@GetMapping("/deletcategorie/{id}")
	public MyResponse delete (@PathVariable("id")int id) {
		
		
		MyResponse res=new MyResponse();
		res.setSuccess(false);
		res.setMessage("Categorie not deleted!!");
		
		if(CategorieService.existsById(id)) {
		
			CategorieService.deleteById(id);
			res.setSuccess(true);
			res.setMessage("Ctaegorie deleted successfully!!");
		}
		return res;
	}
	
	
	@PostMapping("/updatecategorie")
	public Categorie update(int id,String name, boolean work_time){
		
		
		Categorie c=new Categorie();
		c.setId(id);
		c.setName(name);
		c.setWork_time(work_time);
		
		CategorieService.saveAndFlush(c);
		
		return c;
	}
	
	
}
