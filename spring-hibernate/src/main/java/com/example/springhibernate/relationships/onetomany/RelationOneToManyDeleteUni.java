package com.example.springhibernate.relationships.onetomany;

import com.example.springhibernate.course.Course;
import com.example.springhibernate.course.Review;
import com.example.springhibernate.instructor.Instructor;
import com.example.springhibernate.instructor.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RelationOneToManyDeleteUni {

    public static void main(String[] args) {
        Session session = null;
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .buildSessionFactory()) {
            System.out.println("Connection successful !!! ");
            session = factory.getCurrentSession();
            session.beginTransaction();

            Course tempCourse = session.get(Course.class, 4);
            System.out.println(tempCourse.toString());

            session.delete(tempCourse);

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
