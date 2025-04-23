package com.christ.attendanceTracker.repository;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.christ.attendanceTracker.model.Course;
import com.christ.attendanceTracker.model.Student;

@Repository
public class CourseDAOImpl implements CourseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveCourse(Course courseObj) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			session.persist(courseObj);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			// Handle exception
		} finally {
			session.close();
		}
	}

	@Override
	public void saveStudents(List<Student> students) {
		Session session = sessionFactory.openSession();
		Transaction transaction = null;
		try {
			transaction = session.beginTransaction();
			for (Student student : students) {
				session.persist(student);
			}
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			// Handle exception
		} finally {
			session.close();
		}
	}
	
	 @Override
	    public List<Course> getAllCourses() {
	        Session session = sessionFactory.openSession();
	        try {
	            // Retrieve all courses from the database
	            List<Course> courses = session.createQuery("FROM Course", Course.class).list();
	            return courses;
	        } finally {
	            session.close();
	        }
	    }
	 
}
