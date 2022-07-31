package com.example.springhibernate.relationships.onetoone;

import com.example.springhibernate.instructor.Instructor;
import com.example.springhibernate.instructor.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RelationOneToOneBiDirectionalDelete {

    public static void main(String[] args) {
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            int instructorDetailID = 2;
            InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailID);
            //instructorDetail.getInstructor().setInstructorDetail(null);
            System.out.println("Deleting ...");
            session.delete(instructorDetail);

            session.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
