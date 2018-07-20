package com.example.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Region {

	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String desp;
	@Column(name="nbrlieu")
	private int nbrlieu;
	private String photos;
	
	
	public String getPhotos() {
		return photos;
	}
	public void setPhotos(String photos) {
		this.photos = photos;
	}
	@OneToMany(mappedBy="region")
	@JsonIgnore
	private List<Lieu> lieus;
	
	

	
	
	public List<Lieu> getLieus() {
		return lieus;
	}
	public void setLieus(List<Lieu> lieus) {
		this.lieus = lieus;
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
	public String getDesp() {
		return desp;
	}
	public void setDesp(String desp) {
		this.desp = desp;
	}
	
	public int getNbrlieu() {
		return nbrlieu;
	}
	public void setNbrlieu(int nbrlieu) {
		this.nbrlieu = nbrlieu;
	}
	public Region() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
