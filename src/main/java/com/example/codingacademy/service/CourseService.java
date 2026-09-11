package com.example.codingacademy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.codingacademy.bean.Course;
import com.example.codingacademy.repository.CourseRepository;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class CourseService {
	
	@Autowired
	private CourseRepository repo;
	
	public Course addCourse(Course course) {
		
		return repo.save(course);
	}
	
	public List<Course> findCourseByInstructorId(int id){
		return repo.findByInstructorId(id);
	}
	
	public Course findByCourseId(int id) {
		return repo.findById(id);
	}
	
	public List<Course> findAllCourses(){
		return repo.findAll();
	}
	
}
