package com.example.codingacademy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codingacademy.bean.Course;
import com.example.codingacademy.bean.EnrolledCourses;
import com.example.codingacademy.bean.User;
import com.example.codingacademy.service.CourseService;
import com.example.codingacademy.service.EnrolledCoursesService;
import com.example.codingacademy.service.UserService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ViewCourseController {
	
	@Autowired
	CourseService serv;
	
	@Autowired
	UserService userServ;
	
	@Autowired
	EnrolledCoursesService enrolledServ;
	

	@GetMapping("/viewAllCourses")
	public String viewAllCourses(Model model, HttpSession session) {
		
		User user = (User) session.getAttribute("user");
		
		List<EnrolledCourses> enc = enrolledServ.findByUser(user.getId());
		
		List<Course> enrolledCourses = new ArrayList<>();
			
		List<Course> courses = serv.findAllCourses();
		
		for(EnrolledCourses e : enc) {
			enrolledCourses.add(serv.findByCourseId(e.getCourseId()));
		}
			
		for(Course course : enrolledCourses) {
			
			if(courses.contains(course)) {
				courses.remove(course);			}
		}
		
		model.addAttribute("enrolledCourses", enrolledCourses);
		
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
