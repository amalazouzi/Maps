package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.model.Region;
import  com.example.service.RegionService;

@RestController
public class RegionController {

	@Autowired
	RegionService RegionService;
	
	@GetMapping("/regions")
    public List<Region> listregions(){
		
		return RegionService.findAll();
	}
	@PostMapping("/addregion")
	public  Region create(String name,String desp,int nbrlieu) {
		
		Region r=new Region();
		r.setName(name);
		r.setDesp(desp);	
		r.setNbrlieu(nbrlieu);
		
        RegionService.saveAndFlush(r);
		
		return r;
	}
	@GetMapping("/deletregion/{id}")
	public MyResponse delete (@PathVariable("id")int id) {
		
		
		MyResponse res=new MyResponse();
		res.setSuccess(false);
		res.setMessage("Region not deleted!!");
		
		if(RegionService.existsById(id)) {
		
			RegionService.deleteById(id);
			res.setSuccess(true);
			res.setMessage("Region deleted successfully!!");
		}
		return res;
		}
	
	@PostMapping("/updateregion")
	public Region update(int id,String name,String desp,int nbrlieu){
		Region r=new Region();
		r.setId(id);
		r.setName(name);
		r.setDesp(desp);	
		r.setNbrlieu(nbrlieu);
		
        RegionService.saveAndFlush(r);
		
		return r;
		
	
	}
}
