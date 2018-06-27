package com.example.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Categorie {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	public boolean work_time;
	

	public boolean isWork_time() {
		return work_time;
	}
	public void setWork_time(boolean work_time) {
		this.work_time = work_time;
	}
	
	@JsonIgnore
	@OneToMany(mappedBy="cat")
	private List<Lieu> categories;
	
	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	public List<Lieu> getCategories() {
		return categories;
	}
	public void setCategories(List<Lieu> categories) {
		this.categories = categories;
	}
	
	
}
