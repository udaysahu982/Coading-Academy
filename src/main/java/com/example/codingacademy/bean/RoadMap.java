package com.example.codingacademy.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class RoadMap {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private int courseId;
	
	@Lob
	@Column(columnDefinition = "LONGBLOB")
	private byte[] roadMapPdf;

}
