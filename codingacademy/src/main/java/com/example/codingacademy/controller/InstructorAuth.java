package com.example.codingacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.codingacademy.bean.Role;
import com.example.codingacademy.bean.User;
import com.example.codingacademy.service.InstructorService;

import jakarta.validation.Valid;

@Controller
public class InstructorAuth {
	
	@Autowired
	InstructorService service;

	
	@RequestMapping("/instReg")
	public String opnInstructorRegistration(Model m) {
		m.addAttribute("user", new User());
		return "instructorRegister";
	}
	
	@PostMapping("/instructorRegister")
	public String registerInstructor(@Valid @ModelAttribute("user") User i, BindingResult result) {
		
		if(result.hasErrors()) {
			return "instructorRegister";
		}
		
		i.setRole(Role.ROLE_TEACHER);
		
		service.saveInstrucotr(i);
		
		
		return "redirect:/login";
	}
}
