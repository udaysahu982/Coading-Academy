package com.example.codingacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.codingacademy.bean.SectionItem;

public interface SectionItemRepository extends JpaRepository<SectionItem, Integer> {

	List<SectionItem> getBySectionIdAndCourseId(int sectionId, int courseId);
	
	void deleteSectionItemBySectionId(int sectionId);
}
