package com.example.codingacademy.repository;

//import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.codingacademy.bean.Course;
import java.util.List;


public interface CourseRepository extends JpaRepository<Course, Integer> {

	List<Course> findByInstructorId(int instructorId);
	Course findById(int id);
}
