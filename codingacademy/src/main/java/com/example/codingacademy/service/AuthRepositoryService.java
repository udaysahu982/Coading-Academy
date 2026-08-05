package com.example.codingacademy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.codingacademy.bean.User;
import com.example.codingacademy.repository.AuthRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class AuthRepositoryService {
	
	@Autowired
	AuthRepository repo;

	public User findByEmail(String emailId) {
		
		return repo.findByEmail(emailId);
	}
}
