package com.christ.attendanceTracker.repository;

import com.christ.attendanceTracker.model.Professor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProfessorDAOImpl  implements  ProfessorDAO{

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public Professor findByEmail(String email) {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Professor WHERE email = :email", Professor.class)
                    .setParameter("email", email)
                    .uniqueResult();
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            return null;
        }
    }
}
