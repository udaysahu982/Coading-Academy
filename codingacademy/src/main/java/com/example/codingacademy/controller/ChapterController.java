package com.example.codingacademy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.codingacademy.bean.CourseSection;
import com.example.codingacademy.bean.SectionItem;
import com.example.codingacademy.bean.User;
import com.example.codingacademy.service.CourseSectionService;
import com.example.codingacademy.service.SectionItemService;

import jakarta.servlet.http.HttpSession;

@Controller
public class ChapterController {
	
	@Autowired
	CourseSectionService courseSectionService;
	
	@Autowired
	SectionItemService sectionItemService;
	

	@Autowired
	CourseSectionService sectionService;

	@PostMapping("/updateChapter")
	public String editChapterTitle(@ModelAttribute CourseSection courseSection, @RequestParam("sectionId") int sectionId) {
		
		courseSection.setId(sectionId);
		courseSectionService.updateCourseSection(courseSection);
		
		return "redirect:/manageCurriculum?courseId="+courseSection.getCourseId();
				
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
	
	@GetMapping("/deleteChapter")	
	public String deleteChapter(@RequestParam("sectionId") int sectionId, @RequestParam("courseId") int courseId) {
		
		System.out.println("inside Delete By Chapter Id");
		
		courseSectionService.deleteSectionById(sectionId);
		
		sectionItemService.deleteSectionItemBySectionId(sectionId);
		
		return "redirect:/manageCurriculum?courseId="+courseId;			
	}
	
	@GetMapping("/openEditContent")
	public String openEditContent(@RequestParam("contentId") int contentId, Model model) {
		
		System.out.println("open Edit Content" + contentId);
		
		 SectionItem item =  sectionItemService.getByItemId(contentId);
		 
		 System.out.println(item.toString());
		 System.out.println();
		 
		 model.addAttribute("item", item);
		 
		 return "editContent";
	}
	
	@PostMapping("/updateContent")
	public String updateContent(@ModelAttribute SectionItem item, @RequestParam("id") int contentId) {
		
		
		if(item.getItemNotesFile() == null) {
			SectionItem item1=sectionItemService.getByItemId(contentId);
			item.setItemNotesFile(item1.getItemNotesFile());
		}
				
		item.setId(contentId);
				
		
		sectionItemService.updateContent(item);
		return "redirect:/manageCurriculum?courseId=" + item.getCourseId();
	}
	
	@GetMapping("/deleteContent")
	public String deleteContent(@RequestParam("contentId") int id, @RequestParam("courseId") int courseId) {
		
		sectionItemService.deleteById(id);
		
		return "redirect:/manageCurriculum?courseId="+courseId;	
	}
	
}
  // hello