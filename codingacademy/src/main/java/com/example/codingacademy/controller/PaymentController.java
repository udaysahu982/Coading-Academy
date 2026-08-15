package com.example.codingacademy.controller;

import java.security.NoSuchAlgorithmException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HexFormat;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.codingacademy.bean.Course;
import com.example.codingacademy.bean.EnrolledCourses;
import com.example.codingacademy.bean.User;
import com.example.codingacademy.service.CourseService;
import com.example.codingacademy.service.EnrolledCoursesService;
import com.example.codingacademy.service.UserService;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

import jakarta.servlet.http.HttpSession;

@Controller
public class PaymentController {
	
	UserService userService;
	
	@Autowired
	EnrolledCoursesService service;
	
	@Autowired
	CourseService courseService;
	
	
	private String keyId="rzp_test_TKbMXDWDdnRvul";
	

	private String keySecret="2T6PeBqbQOQHlbqDmXmLdM4Z";
	
	@PostMapping("/createOrder")
	@ResponseBody
	public String createOrder(@RequestParam("price") double price) {
		
		try {
			RazorpayClient client = new RazorpayClient(keyId, keySecret);
			
			JSONObject options = new JSONObject();
			options.put("amount", (int) price*100);
			options.put("currency", "INR");
			options.put("receipt", "txn_" + System.currentTimeMillis());
			
			Order order = client.orders.create(options);
			return order.toString();
			
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "{\"error\":\"Something went wrong\"}";
		}
		
	}
	
//	@GetMapping("/enrollCourse")
//	public String enrollCourse(
//	        @RequestParam int courseId,
//	        HttpSession session) {
//
//	    User user =
//	        (User) session.getAttribute("user");
//
//	    
//
//	    return "redirect:/studentHome";
//	}
	
	@PostMapping("/verifyPayment")
	@ResponseBody
	public String verifyPayment(
			@RequestParam("paymentId") String paymentId,
			@RequestParam("orderId") String orderId,
			@RequestParam("signature") String signature,
			@RequestParam("courseId") int courseId,
			HttpSession session
				) {
		try {
			
		String data = orderId +"|" + paymentId;
		SecretKeySpec secreatKey = new SecretKeySpec(keySecret.getBytes(),  "HmacSHA256");
		
		Mac mac = Mac.getInstance("HmacSHA256");
		
		mac.init(secreatKey);
		
		byte[] hash = mac.doFinal(data.getBytes());
		
		String generateSignature = HexFormat.of().formatHex(hash);
		if(generateSignature.equals(signature)) {
			
			User user =  (User)session.getAttribute("user");
			
			EnrolledCourses ec =   new EnrolledCourses();

		    ec.setStudentId(user.getId());

		    ec.setCourseId(courseId);

		    ec.setDate(LocalDate.now());

		    ec.setTime(LocalTime.now());
		    
		    System.out.print(ec.toString());

		   service.saveEnrolledCourse(ec);
		   
		   System.out.println("the Payment success and course added to enrolled course");
		   
		   return "success";
		}
		
		return "failed";
		} 
		
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failed";
		}
		
	}
	
	@GetMapping("/myCourses")
	public String myCourses(HttpSession session, Model model) {
		
		User user = (User)session.getAttribute("user");
		
		List<Integer> courseId = service.findCourseidByUserid(user.getId());
		
		List<Course> courses= new ArrayList<>() ;
		
		for(int i : courseId) {
			
			courses.add(courseService.findByCourseId(i));
		}
		
		model.addAttribute("courses", courses);
		
		return "viewEnrolledCourses";
	}

}
