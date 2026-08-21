package com.example.codingacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.codingacademy.bean.EnrolledCourses;

@Repository
public interface EnrolledCoursesRepository extends JpaRepository<EnrolledCourses, Integer> {

	List<EnrolledCourses> findByUser(int user);
	
}
