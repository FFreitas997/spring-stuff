package com.example.springhibernate.relationships.onetoone;

import com.example.springhibernate.instructor.Instructor;
import com.example.springhibernate.instructor.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RelationOneToOneDelete {

    public static void main(String[] args) {
        System.out.println("Connecting ....");
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory()) {
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            Instructor instructor = session.get(Instructor.class, 1);
            System.out.println("Found Instructor:\n" + instructor);
            if (instructor != null){
                System.out.println("Deleting ....");
                // will also delete associated details object because of CascadeType.ALL
                session.delete(instructor);
            }

            session.getTransaction().commit();
            System.out.println("Work done !!!!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
