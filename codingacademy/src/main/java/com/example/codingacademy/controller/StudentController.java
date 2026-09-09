package com.example.codingacademy.controller;



import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.example.codingacademy.CodingacademyApplication;
import com.example.codingacademy.bean.Course;
import com.example.codingacademy.bean.CourseSection;
import com.example.codingacademy.bean.SectionItem;
import com.example.codingacademy.bean.User;
import com.example.codingacademy.service.CourseSectionService;
import com.example.codingacademy.service.CourseService;
import com.example.codingacademy.service.SectionItemService;

import jakarta.servlet.http.HttpSession;


@Controller
public class StudentController {

//    private final CodingacademyApplication codingacademyApplication;
	
	@Autowired
	CourseService cService;
	
	@Autowired
	CourseSectionService csService;
	
	@Autowired
	SectionItemService siService;

//    StudentController(CodingacademyApplication codingacademyApplication) {
//        this.codingacademyApplication = codingacademyApplication;
//    }
	
	@GetMapping("/studentHome")
	public String studentHome(HttpSession session) {
		User user=(User)session.getAttribute("user");
		
		if(user != null) return "studentHome";
		
		
		return "redirect:/login";
	}
	
	@GetMapping("/viewEnrolledCourse")
	public String viewEnrolledCourse(@RequestParam("courseId") int courseId, Model model) {
		
	System.out.println("==========>  inside viewEnrolledCourse");
		
	 Course course =	cService.findByCourseId(courseId);
	 System.out.println("==========>  " + course.toString());
	 System.out.println("==========>  Course Fetched Successfully");
	 model.addAttribute("course", course);
	 
	 System.out.println(); System.out.println();
	List<CourseSection> courseSections =csService.getSectionByCourseId(courseId);
	System.out.println("==========>  course Section Fetched Successfully");
	System.out.println(" course Section " + courseSections.toString() );
	model.addAttribute("courseSections", courseSections);
	
		
//	List<SectionItem> sectionItems = new ArrayList<>();
//	
//	for(CourseSection cs : courseSections) {
//		List<SectionItem> items= siService.getBySectionIdAndCourseId(cs.getId(), courseId);
//		
//		
//		System.out.println("section title  " + cs.getSectionTitle() + " item size " + items.size());
//	}
//	 
//	model.addAttribute("sectionItems", sectionItems);
	
	 
	 return "viewEnrolledCourse";
		
	}
}
