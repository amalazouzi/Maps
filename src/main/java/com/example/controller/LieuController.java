package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Categorie;
import com.example.model.Contact;
import com.example.model.Lieu;
import com.example.model.Region;
import com.example.model.Review;
import com.example.model.User;
import com.example.service.CategorieService;
import com.example.service.ContactService;
import com.example.service.LieuService;
import com.example.service.RegionService;
import com.example.service.ReviewService;
import com.example.service.UserService;

@RestController

public class LieuController  {

	@Autowired
	LieuService LieuService;
	
	@Autowired CategorieService categorieService;
	
	@Autowired ContactService contactService;
	
	@Autowired RegionService regionService;
	
	@Autowired UserService userService;
	
	@Autowired ReviewService reviewService;
	
	@GetMapping("/lieus")
    public List<Lieu> listlieus(){
		
		return LieuService.findAll();
	}
	
	
	@GetMapping("/lieu/{id}")
    public Lieu getlieu(@PathVariable("id") int id) {
		
		return LieuService.getOne(id);
	}
	@PostMapping("/addLieu")
	public  Lieu create(String name,String adress,String description,float longt,float lat,String open_at,String close_at, String photo,
			int cat,int reg) {
		
		Categorie categorie=categorieService.getOne(cat);
		Region region=regionService.getOne(reg);
		
		
		Lieu l=new Lieu();
		l.setDescription(description);
		l.setName(name);
		l.setAdress(adress);
		l.setLongt(longt);
		l.setLat(lat);
		l.setCat(categorie);
        l.setPhoto(photo);
        l.setRegion(region);
        if(categorie.isWork_time())
		{
			l.setOpen_at(open_at);
			l.setClose_at(close_at);
		}


		LieuService.saveAndFlush(l);
		
		return l;
	}
	@GetMapping("/deletLieu/{id}")
	public MyResponse  delete (@PathVariable("id")int id) {
		
		MyResponse res=new MyResponse();
		res.setSuccess(false);
		res.setMessage("Lieu not deleted!!");
		
		if(LieuService.existsById(id)) {
		
			LieuService.deleteById(id);
			res.setSuccess(true);
			res.setMessage("Lieu deleted successfully!!");
			
		}
		
		
		
		return res;
		}
	
	
	
	@PostMapping("/updatelieu")
	public Lieu update(int id ,String name,String adress,String description,float longt,float lat,String open_at,String close_at, String photo
			,int cat){
		
		Categorie categorie=categorieService.getOne(cat);
		Lieu l=new Lieu();
		l.setId(id);
		l.setDescription(description);
		l.setName(name);
		l.setAdress(adress);
		l.setLongt(longt);
		l.setLat(lat);
		l.setCat(categorie);
        l.setPhoto(photo);
		if(categorie.isWork_time())
		{
			l.setOpen_at(open_at);
			l.setClose_at(close_at);
		}

		LieuService.saveAndFlush(l);
		
		return l;
		
	
	}
	
	@PostMapping("/addContact")
	public Contact create (String type,String name,String content,@RequestParam("id_lieu") int id_lieu) {
		Lieu lieu=LieuService.getOne(id_lieu);
		
		Contact c =new Contact();
		c.setType(type);
		c.setName(name);
		c.setContent(content);
		c.setLieu(lieu);
		contactService.saveAndFlush(c);
		
		return c;
	}
	
	@PostMapping("/addreview")
	public Review create (int avis,String cmntr,@RequestParam("id_user")int id_user,
			@RequestParam("id_lieu") int id_lieu) {
		
		User user=userService.getOne(id_user);	
		Lieu lieu=LieuService.getOne(id_lieu);
		
		Review rv = new Review();
		rv.setAvis(avis);
		rv.setCmntr(cmntr);
		rv.setLieu(lieu);
		rv.setUser(user);
		
		reviewService.saveAndFlush(rv);
		
		
		return rv;
	}
	
	@GetMapping("/userreview/{user}")
	public List<Review> listuser(@PathVariable("user")int id_user){
		User user=userService.getOne(id_user);
		
		return reviewService.findByUser(user);
	}
	
	@GetMapping("/deletcontact/{id}")
	public MyResponse delete2(@PathVariable("id")int id) {
		
		MyResponse res=new MyResponse();
		res.setSuccess(false);
		res.setMessage("contact not deleted!!");
		
		if(contactService.existsById(id)) {
		
			contactService.deleteById(id);
			res.setSuccess(true);
			res.setMessage("contact deleted successfully!!");
		}
			return res;
		}
	
	}
