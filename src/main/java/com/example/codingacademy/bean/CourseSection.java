package com.example.codingacademy.bean;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class CourseSection {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String sectionTitle;
	private int courseId;
	
	@OneToMany(mappedBy = "sectionId", cascade = CascadeType.ALL)
	private List<SectionItem> items;

	public CourseSection() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	public CourseSection(int id, String sectionTitle, int courseId, List<SectionItem> items) {
		super();
		this.id = id;
		this.sectionTitle = sectionTitle;
		this.courseId = courseId;
		this.items = items;
	}






	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSectionTitle() {
		return sectionTitle;
	}

	public void setSectionTitle(String sectionTitle) {
		this.sectionTitle = sectionTitle;
	}

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public List<SectionItem> getItems() {
		return items;
	}

	public void setItems(List<SectionItem> items) {
		this.items = items;
	}

	@Override
	public String toString() {
		return "CourseSection [id=" + id + ", sectionTitle=" + sectionTitle + ", courseId=" + courseId  + "]";
	}
	
	
	

}
