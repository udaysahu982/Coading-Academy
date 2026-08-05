package com.example.codingacademy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.codingacademy.bean.User;
import com.example.codingacademy.repository.UserRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserService  {

	@Autowired
	UserRepository userRepo;
	
	public User findUserDetailsByUserId(int id) {
		return userRepo.getById(id);
	}
	
}
