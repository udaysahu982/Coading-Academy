package com.example.codingacademy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codingacademy.bean.Course;
import com.example.codingacademy.bean.User;
import com.example.codingacademy.service.CourseService;
import com.example.codingacademy.service.UserService;

@Controller
public class ViewCourseController {
	
	@Autowired
	CourseService serv;
	
	@Autowired
	UserService userServ;
	

	@GetMapping("/viewAllCourses")
	public String viewAllCourses(Model model) {
		
		List<Course> courses = serv.findAllCourses();
		
		model.addAttribute("courses", courses );
		
		return "viewAllCourses";
	}
	
	@GetMapping("/viewCourse")
	public String viewCourse(@RequestParam("id") int courseId, Model model) {
		
		Course course = serv.findByCourseId(courseId);
		User user = userServ.findUserDetailsByUserId(course.getInstructorId());
		
		model.addAttribute("course", course);
		model.addAttribute("instructorName", user.getName());
		
		return "viewCourse";
	}
}
