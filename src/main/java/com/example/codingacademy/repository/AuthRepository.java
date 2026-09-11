package com.example.codingacademy.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.codingacademy.bean.User;

@Repository
public interface AuthRepository extends JpaRepository<User, Integer> {

	User findByEmail(String emailId);
	
}
