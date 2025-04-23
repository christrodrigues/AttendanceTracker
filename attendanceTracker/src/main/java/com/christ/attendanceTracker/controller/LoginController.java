package com.christ.attendanceTracker.controller;

import com.christ.attendanceTracker.repository.ProfessorDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import com.christ.attendanceTracker.model.Professor;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.ui.Model;

@Controller
public class LoginController {
	

    @Autowired
    private ProfessorDAO professorDAO;

	@GetMapping("/user.htm")
	public String userType(HttpServletRequest request, HttpServletResponse response) throws IOException {
		System.out.println("user Type reached");
		
		HttpSession session =request.getSession(false);
		
		 if (session != null) {
			String userType=(String)session.getAttribute("userType");
			if("professor".equals(userType)) {
				response.sendRedirect("/professorDashboard.htm");
				return null;
			}else if("student".equals(userType)) {
				// return "studentDashboard";
			}
	      }
		return "user";
	}
	

	@PostMapping("/professorLogin.htm")
	public String professor() {
		System.out.println("professorLogin reached");
		return "professorLogin";
	}
	
	@GetMapping("/professorDashboard.htm")
	public String getprofDasboard(HttpServletRequest request, HttpServletResponse response) {
	
			return "professorDashboard";
	}
	
	@PostMapping("/studentLogin.htm")
	public String student() {
		System.out.println("studentLogin reached");
		return "studentLogin";
	}
	

	 @PostMapping("/professorDashboard.htm")
	    public String professorLogin(HttpServletRequest request,HttpServletRequest response,@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
	        try {
	            Professor professor = professorDAO.findByEmail(email);
	            if (professor != null && professor.getPassword().equals(password)) {
	            	HttpSession session=request.getSession(false);
	            	session.setAttribute("user", professor);
	            	session.setAttribute("userType", "professor");
	                return "professorDashboard";
	            } else {
	                
	                return "professorLogin";
	            }
	            
	        } catch (Exception e) {
	            // Handle exceptions
	            e.printStackTrace();
	            model.addAttribute("error", "An error occurred. Please try again later.");
	            return "professorLogin";
	        }
	 }

	}