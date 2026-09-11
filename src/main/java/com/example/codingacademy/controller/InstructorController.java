package com.example.codingacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.codingacademy.bean.Category;
import com.example.codingacademy.bean.Course;
import com.example.codingacademy.bean.User;
import com.example.codingacademy.service.CategoryService;
import com.example.codingacademy.service.CourseService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class InstructorController {
	
	@Autowired
	CourseService serv;
	
	@Autowired
	CategoryService categoryServ;

	@RequestMapping("/instructorHome")
	public String instructorHome(HttpSession session) {
		User user = (User)session.getAttribute("user");
		
		if(user != null) return "instructorHome";
		
		
	return  "redirect:/login";
	}
	
 // Open's the Add Course Page
    
    @GetMapping("/openAddCourse")
	public String openAddCourse(Model m) {
    	
    	List<Category> categoryList = categoryServ.findAllCategory();
    	
    	m.addAttribute("categoryList", categoryList);
		m.addAttribute("course", new Course());
		return "addCourse";
	}
	
    // Saves The Course And instructor id with it
    
	@PostMapping("/saveCourse")
	public String saveCourse(@Valid @ModelAttribute Course course, BindingResult result,HttpSession session) {
		
		User user = (User)session.getAttribute("user");
				
		course.setInstructorId(user.getId());
		
		System.out.println("Course Save Successfully");
		
		serv.addCourse(course);
		
		return "instructorHome";
	}
	
	// find the course by the instrucor id 
	
	@GetMapping("/viewPublishedCourses")
	public String viewPublishedCourses(Model m, HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		
		int instructorId=user.getId();
		System.out.println("inside view publish controller");
		List<Course> courses = serv.findCourseByInstructorId(instructorId);
		
		m.addAttribute("courses", courses);
		System.out.println("inside viewcourses");
		return "viewpublishedCourses";
		
	}
	
	
}
