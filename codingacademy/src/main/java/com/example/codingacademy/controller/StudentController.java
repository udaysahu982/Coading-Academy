package com.example.codingacademy.controller;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.codingacademy.bean.User;

import jakarta.servlet.http.HttpSession;



@Controller
public class StudentController {
	
	@GetMapping("/studentHome")
	public String studentHome(HttpSession session) {
		User user=(User)session.getAttribute("user");
		
		if(user != null) return "studentHome";
		
		
		return "redirect:/login";
	}
}
