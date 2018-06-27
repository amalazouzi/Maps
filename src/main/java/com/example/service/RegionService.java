package com.example.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Region;

public interface RegionService extends JpaRepository <Region, Integer> {

}
