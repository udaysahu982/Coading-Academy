package com.example.codingacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codingacademy.bean.Role;
import com.example.codingacademy.bean.User;
import com.example.codingacademy.service.AuthRepositoryService;
import com.example.codingacademy.service.StudentService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class AuthController {
	
	@Autowired
	StudentService serve;
	
	@Autowired
	AuthRepositoryService authService;
	
	@RequestMapping("/streg")
	public String openForm(Model m) {
		m.addAttribute("user", new User());
		return "studentRegister";
	}
	
	@PostMapping("/studentRegister")
	public String registerStudent(@Valid @ModelAttribute("user") User s, BindingResult result) {
		
		if(result.hasErrors()) {
			return "studentRegister";
		}
		
		s.setRole(Role.ROLE_STUDENT);
		
		serve.saveStudent(s);
		
		
		return "redirect:/login";
	}
	
	@RequestMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@PostMapping("/loginuser")
	public String login(@RequestParam("loginid") String loginId, @RequestParam("password") String password, HttpSession session, Model model) {
		System.out.println("inside login controller");
		
		User user = authService.findByEmail(loginId);
		
		if(user==null) {
		model.addAttribute("error", "Invalid username or Password");
		return "login";
		}
		
		if(user.getPassword().equals(password) ) {
			
			session.setAttribute("user", user);
			
			if(user.getRole().equals(Role.ROLE_STUDENT)) {
				
				return "redirect:/studentHome";
				}	
			
			else if(user.getRole().equals(Role.ROLE_TEACHER)){	
				
				return "redirect:/instructorHome";
			}
			
			else if(user.getRole().equals(Role.ROLE_ADMIN)) {
				
				return "adminHome";
			}
						
		}		
		
		model.addAttribute("error", "Invalid username or Password");
		return "login";
		
	}

	
	
	
}
