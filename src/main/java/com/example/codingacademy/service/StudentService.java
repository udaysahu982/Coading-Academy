package com.example.codingacademy.service;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.codingacademy.bean.User;
import com.example.codingacademy.repository.AuthRepository;


import jakarta.transaction.Transactional;

@org.springframework.stereotype.Service
@Transactional
public class StudentService {
	
	@Autowired
	private AuthRepository repo;

	public User saveStudent(User s) {
		return repo.save(s);
	}
	
	
	
}
