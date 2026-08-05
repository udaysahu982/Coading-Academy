package com.example.codingacademy.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.codingacademy.bean.Category;
import com.example.codingacademy.repository.CategoryRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepo;
	
	public List<Category> findAllCategory(){
		return categoryRepo.findAll();
	}

}
