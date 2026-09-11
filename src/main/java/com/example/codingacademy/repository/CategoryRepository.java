package com.example.codingacademy.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.codingacademy.bean.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	List<Category> findAll();

}
