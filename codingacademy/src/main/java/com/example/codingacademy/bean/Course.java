package com.example.codingacademy.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	
	@NotBlank(message = "Course Title is Required")
	private String title;
	private String description;
	private String category;
    private String level;
    private double price;
    
    // Storing the instructor ID directly as a simple integer
    private int instructorId;

	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Course(int id, @NotBlank(message = "Course Title is Required") String title, String description,
			String category, String level, double price, int instructorId) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.category = category;
		this.level = level;
		this.price = price;
		this.instructorId = instructorId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getInstructorId() {
		return instructorId;
	}

	public void setInstructorId(int instructorId) {
		this.instructorId = instructorId;
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", title=" + title + ", description=" + description + ", category=" + category
				+ ", level=" + level + ", price=" + price + ", instructorId=" + instructorId + "]";
	}
    
    

}
