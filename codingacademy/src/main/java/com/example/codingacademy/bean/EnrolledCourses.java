package com.example.codingacademy.bean;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EnrolledCourses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int user;
	private int courseId;
	private LocalDate date;
	private LocalTime time;
	
	
	public EnrolledCourses() {
		super();
		// TODO Auto-generated constructor stub
	}


	public EnrolledCourses(int id, int user, int courseId, LocalDate date, LocalTime time) {
		super();
		this.id = id;
		this.user = user;
		this.courseId = courseId;
		this.date = date;
		this.time = time;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getuser() {
		return user;
	}


	public void setuser(int user) {
		this.user = user;
	}


	public int getCourseId() {
		return courseId;
	}


	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}


	public LocalDate getDate() {
		return date;
	}


	public void setDate(LocalDate date) {
		this.date = date;
	}


	public LocalTime getTime() {
		return time;
	}


	public void setTime(LocalTime time) {
		this.time = time;
	}
	
	
	
	

}
