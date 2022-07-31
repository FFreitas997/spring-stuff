package com.example.springhibernate.relationships.onetoone;

import com.example.springhibernate.instructor.Instructor;
import com.example.springhibernate.instructor.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RelationOneToOneCreate {

    public static void main(String[] args) {
        System.out.println("Connecting ....");
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {
            System.out.println("Connection successful !!! ");
            Session session = factory.getCurrentSession();

            InstructorDetail instructorDetail = new InstructorDetail("https://www.youtube.com", "Playing video games");
            Instructor instructor = new Instructor("Francisco", "Freitas", "francisco@luv2code.com");
            instructor.setInstructorDetail(instructorDetail);

            session.beginTransaction();

            // this will also save the details object because of cascade.all
            System.out.println("Saving instructor:\n" + instructor);
            session.save(instructor);

            System.out.println("Committing ...");
            session.getTransaction().commit();
            System.out.println("Work done !!!!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
