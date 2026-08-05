package com.example.codingacademy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.codingacademy.bean.EnrolledCourses;
import com.example.codingacademy.repository.EnrolledCoursesRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class EnrolledCoursesService {

	@Autowired
	EnrolledCoursesRepository repo;
	
	public EnrolledCourses saveEnrolledCourse(EnrolledCourses ec) {
		return repo.save(ec);
	}
}
