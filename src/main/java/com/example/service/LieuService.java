package com.example.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Categorie;
import com.example.model.Lieu;
import com.example.model.Region;

public interface LieuService extends JpaRepository<Lieu, Integer> {

	
	
	
	List<Lieu> findByCatAndRegion(Categorie cat,Region reg);
	
}
