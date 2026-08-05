package com.example.codingacademy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.codingacademy.bean.SectionItem;
import com.example.codingacademy.repository.SectionItemRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class SectionItemService {
	
	@Autowired
	SectionItemRepository sectionItemRepo;
	
	public List<SectionItem> getBySectionIdAndCourseId(int sectionId, int courseId){
		return sectionItemRepo.getBySectionIdAndCourseId(sectionId, courseId);
	}
	
	public SectionItem saveItem(SectionItem item) {
		return sectionItemRepo.save(item);
	}
	public SectionItem getByItemId(int itemId) {
		return sectionItemRepo.getById(itemId);
	}
	
	public void deleteById(int id) {
		sectionItemRepo.deleteById(id);
	}
	
	public void deleteSectionItemBySectionId(int sectionId) {
		sectionItemRepo.deleteSectionItemBySectionId(sectionId);
	}
	
	
	public SectionItem updateContent(SectionItem item) {
		return sectionItemRepo.save(item);
	}
}
