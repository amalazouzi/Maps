package com.example.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Lieu;

public interface LieuService extends JpaRepository<Lieu, Integer> {

}
