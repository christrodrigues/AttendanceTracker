package com.christ.attendanceTracker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;

import com.christ.attendanceTracker.model.Student;
import com.christ.attendanceTracker.model.response.CourseResponse;
import com.christ.attendanceTracker.model.Course;
import com.christ.attendanceTracker.repository.CourseDAO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ProfessorController {

    @Autowired
	private CourseDAO courseDAO;

//    public ProfessorController(CourseDAO courseDAO) {
//        this.courseDAO = courseDAO;
//    }

    @PostMapping("/addClass.htm")
    public String addClass() {
        return "createClass";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Invalidate the session
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        // Redirect to the login page
        response.sendRedirect("/user.htm");
        return null;
    }
    
    @GetMapping("/professor/courseList")
    @ResponseBody
    public List<CourseResponse> professorDashboard(Model model) {
        // Retrieve all courses
        List<Course> courses = courseDAO.getAllCourses();
        List<CourseResponse> response= new ArrayList<CourseResponse>();
        for(Course course:courses) {
        	CourseResponse res= new CourseResponse();
        	res.setCourseCode(course.getCourseCode());
        	res.setCourseTitle(course.getCourseTitle());
        	res.setCourseYear(course.getCourseYear());
        	res.setSemester(course.getSemester());
        	res.setId(course.getId());
        	response.add(res);
        }
        return response;
    }
	
    
    

    @PostMapping("/createClass.htm")
    public String createClass(@ModelAttribute Course course, Model model, @RequestParam("csvFile") MultipartFile csvFile) {
        // Extract class information from the form
//        String classTitle = course.getCourseTitle();
//        String classCode = course.getCourseCode();
//        int classYear = course.getCourseYear();
//        String semester = course.getSemester();
        courseDAO.saveCourse(course);
        // Process CSV file to get student information
        List<Student> students = new ArrayList<>();
        if (csvFile != null) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(csvFile.getInputStream()));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] data = line.split(",");
                    
                    if (data.length == 3 && !data[0].equals("First Name")) {
                        Student student = new Student();
                        student.setFirstName(data[0]);
                        student.setLastName(data[1]);
                        student.setEmail(data[2]);
                        
                        student.setCourseInfo(course);
                        students.add(student);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        // Set students for the course
//        course.setStudents(students);

        // Save the course and its students
        
        courseDAO.saveStudents(students);

        // Redirect to a success page
        return "professorDashboard";
    }
    
    
}
