package com.example.codingacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.codingacademy.bean.EnrolledCourses;

@Repository
public interface EnrolledCoursesRepository extends JpaRepository<EnrolledCourses, Integer> {

}
