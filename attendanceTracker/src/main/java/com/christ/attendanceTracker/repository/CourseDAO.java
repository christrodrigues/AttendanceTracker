package com.christ.attendanceTracker.repository;

import java.util.List;
import com.christ.attendanceTracker.model.Course;
import com.christ.attendanceTracker.model.Student;

public interface CourseDAO {
    void saveCourse(Course courseObj);
    void saveStudents(List<Student> students);
    
    List<Course> getAllCourses();
}
