package com.example.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Review {
	
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	private int avis;
	private String cmntr;
	
	@ManyToOne
	@JoinColumn(name="lieu_id")
	private Lieu lieu;
	
	
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;
	
	
	public int getAvis() {
		return avis;
	}
	public void setAvis(int avis) {
		this.avis = avis;
	}
	public String getCmntr() {
		return cmntr;
	}
	public void setCmntr(String cmntr) {
		this.cmntr = cmntr;
	}
	public Review() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Lieu getLieu() {
		return lieu;
	}
	public void setLieu(Lieu lieu) {
		this.lieu = lieu;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
