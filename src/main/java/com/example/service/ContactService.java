package com.example.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Contact;

public interface ContactService extends JpaRepository<Contact, Integer> {

}
