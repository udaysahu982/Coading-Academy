package com.example.codingacademy.bean;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Lob;

@Entity
public class SectionItem {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    private String itemTitle;
    
    @Column(columnDefinition = "TEXT")
    private String itemText;
    
    @Lob  // <-- Tells JPA/Hibernate this is a Large Object (BLOB)
    @Column(columnDefinition = "LONGBLOB")  // <-- Ensures MySQL creates a LONGBLOB to safely fit PDFs/images
    private byte[] itemNotesFile;          // <-- Stores raw binary data of the single uploaded file
    
    private String itemYtLink;
    private int courseId;
    private int sectionId;

    public SectionItem() {
        super();
    }
    
    
    

    public SectionItem(int id, String itemTitle, String itemText, byte[] itemNotesFile, String itemYtLink, int courseId,
			int sectionId) {
		super();
		this.id = id;
		this.itemTitle = itemTitle;
		this.itemText = itemText;
		this.itemNotesFile = itemNotesFile;
		this.itemYtLink = itemYtLink;
		this.courseId = courseId;
		this.sectionId = sectionId;
	}




	// Getters and Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    
    public String getItemTitle() { return itemTitle; }
    public void setItemTitle(String itemTitle) { this.itemTitle = itemTitle; }
    
    public String getItemText() { return itemText; }
    public void setItemText(String itemText) { this.itemText = itemText; }
    
    public byte[] getItemNotesFile() { return itemNotesFile; }
    public void setItemNotesFile(byte[] itemNotesFile) { this.itemNotesFile = itemNotesFile; }
    
    public String getItemYtLink() { return itemYtLink; }
    public void setItemYtLink(String itemYtLink) { this.itemYtLink = itemYtLink; }
    
    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }
    
    public int getSectionId() { return sectionId; }
    public void setSectionId(int sectionId) { this.sectionId = sectionId; }

	@Override
	public String toString() {
		return "SectionItem [id=" + id + ", itemTitle=" + itemTitle + ", itemText=" + itemText + ", itemNotesFile="
				+ Arrays.toString(itemNotesFile) + ", itemYtLink=" + itemYtLink + ", courseId=" + courseId
				+ ", sectionId=" + sectionId + "]";
	}
    
    
}