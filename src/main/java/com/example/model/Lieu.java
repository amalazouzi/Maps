package com.example.model;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Lieu {

	private String name;
	private String adress;
	public Lieu() {
		super();
		// TODO Auto-generated constructor stub
	}
	private String description;
	private float longt;
	private float lat;
	private String open_at;
	private String close_at;
	private String photo;
	
	@ManyToOne
	@JoinColumn(name="region_id")
	private Region region;
	
	@ManyToOne
	@JoinColumn(name="categorie_id")
	private Categorie cat;
	
	 @OneToMany(mappedBy="lieu")
	  private List<Contact> contact;
	 
	@Id 
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@OneToMany(mappedBy="lieu")
	@JsonIgnore
	private List<Review> reviews;
	
	
	
	
	
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
	public String getAdress() {
		return adress;
	}
	public void setAdress(String adress) {
		this.adress = adress;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getLongt() {
		return longt;
	}
	public void setLongt(float longt) {
		this.longt = longt;
	}
	public double getLat() {
		return lat;
	}
	public void setLat(float lat) {
		this.lat = lat;
	}
	public String getOpen_at() {
		return open_at;
	}
	public void setOpen_at(String open_at) {
		this.open_at = open_at;
	}
	public String getClose_at() {
		return close_at;
	}
	public void setClose_at(String close_at) {
		this.close_at = close_at;
	}
	public String getPhoto() {
		return photo;
	}
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	public Region getRegion() {
		return region;
	}
	public void setRegion(Region region) {
		this.region = region;
	}
	public Categorie getCat() {
		return cat;
	}
	public void setCat(Categorie cat) {
		this.cat = cat;
	}
	public List<Contact> getContact() {
		return contact;
	}
	public void setContact(List<Contact> contact) {
		this.contact = contact;
	}
	public List<Review> getReviews() {
		return reviews;
	}
	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}
	
	
	
}
