package com.christ.attendanceTracker.repository;

import com.christ.attendanceTracker.model.Professor;


public interface  ProfessorDAO {
   public Professor findByEmail(String email);
}
