package com.example.codingacademy.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.codingacademy.bean.Course;
import com.example.codingacademy.bean.EnrolledCourses;
import com.example.codingacademy.bean.User;
import com.example.codingacademy.service.CourseService;
import com.example.codingacademy.service.EnrolledCoursesService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EnrolledCourseController {
	
	@Autowired
	EnrolledCoursesService enrolledCourseService;
	
	@Autowired
	CourseService courseService;

	@GetMapping("/viewEnrolledCourses")
	public String viewEnrolledCourse( HttpSession session, Model model) {
		
		System.out.println("Inside viewEnrolledCourses");
		
		User user=(User) session.getAttribute("user");
		
		int userId =   user.getId();
		
		List<EnrolledCourses> enrolledList = enrolledCourseService.findByUser(userId);
		
		List<Course> enrolledCoursesList = new ArrayList<>();
		
		for(EnrolledCourses enc : enrolledList) {
			
			enrolledCoursesList.add(courseService.findByCourseId(enc.getCourseId()));
		}
		
		model.addAttribute("enrolledCoursesList", enrolledCoursesList);
		
		return "viewEnrolledCourses";
	}
	
	

//	@GetMapping("/myCourses")
//	public String myCourses(HttpSession session, Model model) {
//		
//		User user = (User)session.getAttribute("user");
//		
//		List<Integer> courseId = service.findCourseidByUserid(user.getId());
//		
//		List<Course> courses= new ArrayList<>() ;
//		
//		for(int i : courseId) {
//			
//			courses.add(courseService.findByCourseId(i));
//		}
//		
//		model.addAttribute("courses", courses);
//		
//		return "viewEnrolledCourses";
//	}
	
}
