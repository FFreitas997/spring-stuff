package com.example.springhibernate.relationships.onetomany;

import com.example.springhibernate.course.Course;
import com.example.springhibernate.instructor.Instructor;
import com.example.springhibernate.instructor.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RelationOneToManyGet {

    public static void main(String[] args) {
        System.out.println("Connecting ....");
        Session session = null;
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .buildSessionFactory()) {
            System.out.println("Connection successful !!! ");
            session = factory.getCurrentSession();

            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 4);

            System.out.println(instructor.toString());

            System.out.println("Committing ...");
            session.getTransaction().commit();
            System.out.println("Work done !!!!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            if (session != null)
                session.close();
        }
    }
}
