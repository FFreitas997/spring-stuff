package com.example.springhibernate.relationships.onetoone;

import com.example.springhibernate.instructor.Instructor;
import com.example.springhibernate.instructor.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RelationOneToOneBiDirectional {

    public static void main(String[] args) {
        Session session = null;
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {
            session = factory.getCurrentSession();
            session.beginTransaction();

            int instructorDetailID = 3;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailID);
            System.out.println("Found instructor detail: " + instructorDetail);
            System.out.println("Found instructor: \n" + instructorDetail.getInstructor());

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session != null) session.close();
            System.out.println("Error: " + e.getMessage());
        }
    }
}
