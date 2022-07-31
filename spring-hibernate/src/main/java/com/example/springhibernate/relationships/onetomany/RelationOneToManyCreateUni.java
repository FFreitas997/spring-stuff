package com.example.springhibernate.relationships.onetomany;

import com.example.springhibernate.course.Course;
import com.example.springhibernate.course.Review;
import com.example.springhibernate.instructor.Instructor;
import com.example.springhibernate.instructor.InstructorDetail;
import com.example.springhibernate.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RelationOneToManyCreateUni {

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

            Course tempCourse = new Course("Pacman - How to Score One Million Points");
            tempCourse.addReview(
                    new Review("Great course ... loved it !"),
                    new Review("Cool course, job well done"),
                    new Review("What a dumb course, you are an idiot!")
            );

            session.save(tempCourse);

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
