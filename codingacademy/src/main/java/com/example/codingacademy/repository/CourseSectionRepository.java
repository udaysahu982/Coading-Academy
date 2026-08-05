package com.example.codingacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.codingacademy.bean.CourseSection;

@Repository
public interface CourseSectionRepository extends JpaRepository<CourseSection, Integer> {

	List<CourseSection> getSectionsByCourseId(int id);
	
}
