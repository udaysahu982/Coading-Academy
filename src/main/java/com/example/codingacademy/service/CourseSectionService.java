package com.example.codingacademy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.codingacademy.bean.CourseSection;
import com.example.codingacademy.repository.CourseSectionRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CourseSectionService {
	
	@Autowired
	CourseSectionRepository repo;
	
	public List<CourseSection> getSectionByCourseId(int id){
		return repo.getSectionsByCourseId(id);
	}
	
	public CourseSection saveSection(CourseSection section) {
		return repo.save(section);
	}
	
	public CourseSection updateCourseSection(CourseSection cs) {
		return repo.save(cs);
	}
	
	public void deleteSectionById(int id) {
		 repo.deleteById(id);
		 System.out.println("The item is deleted " + id);
	}

}
