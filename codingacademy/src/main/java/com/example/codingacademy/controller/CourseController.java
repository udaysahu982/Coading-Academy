package com.example.codingacademy.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.codingacademy.bean.Category;
import com.example.codingacademy.bean.Course;
import com.example.codingacademy.bean.CourseSection;
import com.example.codingacademy.bean.SectionItem;
import com.example.codingacademy.bean.User;
import com.example.codingacademy.repository.CourseRepository;
import com.example.codingacademy.service.CategoryService;
import com.example.codingacademy.service.CourseSectionService;
import com.example.codingacademy.service.CourseService;
import com.example.codingacademy.service.SectionItemService;
import com.example.codingacademy.service.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class CourseController {

    private final StudentController studentController;

    private final CourseRepository courseRepository;

	@Autowired
	CourseService serv;
	
	@Autowired
	CourseSectionService sectionService;
	
	@Autowired
	SectionItemService itemService;
	
	@Autowired
	CategoryService categoryServ;
	
	@Autowired
	UserService userServ;

    CourseController(CourseRepository courseRepository, StudentController studentController) {
        this.courseRepository = courseRepository;
        this.studentController = studentController;
    }
    
    
   
    
	
	@GetMapping("/manageCurriculum")
	public String openAddMaterial(@RequestParam("courseId") int id, Model model, HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		
		if(user == null) return "redirect:/login";
		
		
		Course course=serv.findByCourseId(id);
		
		System.out.println(course.toString());
		
		List<CourseSection> sections = sectionService.getSectionByCourseId(id);
		
		System.out.println(sections.toString());
		
		for(CourseSection sec : sections) {
			
			List<SectionItem> item = itemService.getBySectionIdAndCourseId(sec.getId(), course.getId());
			sec.setItems(item);
		}
		
		model.addAttribute("course", course);
		model.addAttribute("section", sections);
		
		return "manageCurriculum";	
	}
	
	@PostMapping("/addChapter")
    public String addChapterSection( @RequestParam("courseId") int courseId, @RequestParam("sectionTitle") String sectionTitle, HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		if(user == null) return "redirect:/login";
        
        CourseSection section = new CourseSection();
        section.setCourseId(courseId);
        section.setSectionTitle(sectionTitle);
        sectionService.saveSection(section);
        
        return "redirect:/manageCurriculum?courseId=" + courseId;
    }
	
	@GetMapping("/openAddSectionItem")
	public String openAddItem(@RequestParam("sectionId") int sectionId, @RequestParam("courseId") int courseId, Model model, HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		if(user == null) return "redirect:/login";
		
		model.addAttribute("sectionId", sectionId);
		model.addAttribute("courseId", courseId);
		
		return "addSectionItem";
		
	}
	
	@PostMapping("/addSectionItem")
	public String addSectionItem(@ModelAttribute SectionItem item, @RequestParam(value = "notesFile", required = false) MultipartFile notesFile) {
		
		System.out.println("under addSEctionItem");
		System.out.println(item.toString());
		
		try {
			if(notesFile != null && !notesFile.isEmpty()) {
				item.setItemNotesFile(notesFile.getBytes());
			}
		}
		catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		itemService.saveItem(item);
		return "redirect:/manageCurriculum?courseId=" + item.getCourseId();
	}
	
	@GetMapping("/openViewContent")
	public String viewContent(@RequestParam("itemId") int itemId, Model model, HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		if(user == null) return "redirect:/login";
		
		SectionItem item = itemService.getByItemId(itemId);
		model.addAttribute("item", item);
		System.out.println("the view Content is called");
		System.out.println(item);
		
		return "viewContent";
		
	}
	
	@GetMapping("/viewItemFile")
	public ResponseEntity<byte[]> viewItemFile(@RequestParam("id") int id){
	    
	    SectionItem item = itemService.getByItemId(id);
	    
	    if(item != null && item.getItemNotesFile() != null) {
	        
	        HttpHeaders headers = new HttpHeaders();
	        // Tells the browser to display the image inline instead of downloading it
	        headers.setContentType(MediaType.APPLICATION_PDF); 
	        
	        return new ResponseEntity<>(item.getItemNotesFile(), headers, HttpStatus.OK);
	    }
	    return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/openEditCourse")
	public String openEditCourse(@RequestParam("courseId") int courseId, Model model, HttpSession session) {
		
		User user = (User)session.getAttribute("user");
		if(user == null) return "redirect:/login";
		
		System.out.print("open Edit Course is open");
		
		Course course = serv.findByCourseId(courseId);
		
		List<Category> categoryList = categoryServ.findAllCategory();
		
		model.addAttribute("categoryList", categoryList);
		model.addAttribute("course", course);
		
		System.out.print("Data is Fetched" + course.toString());
		
		return "editCourse";
	}
	
	@PostMapping("/editCourse")
	public String editCourse(@ModelAttribute Course course) {

		System.out.print("edit ecourse is opened");
		
		
		serv.addCourse(course);
		return "redirect:/viewPublishedCourses";
	}
	
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
