package com.example.springhibernate.relationships.manytomany;

import com.example.springhibernate.course.Course;
import com.example.springhibernate.course.Review;
import com.example.springhibernate.instructor.Instructor;
import com.example.springhibernate.instructor.InstructorDetail;
import com.example.springhibernate.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RelationManyToManyCreate {

    public static void main(String[] args) {
        System.out.println("Connecting ....");
        Session session = null;
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            System.out.println("Connection successful !!! ");
            session = factory.getCurrentSession();
            session.beginTransaction();

            Course course1 = session.get(Course.class, 5);
            Course course2 = session.get(Course.class, 3);
            Course course3 = session.get(Course.class, 2);

            Student student1 = session.get(Student.class, 4);
            Student student2 = session.get(Student.class, 5);
            Student student3 = session.get(Student.class, 6);

            for (Course course : List.of(course1, course2, course3)) {
                System.out.println(course);
            }

            for (Student student : List.of(student1, student2, student3)) {
                System.out.println(student);
            }

            course1.addStudents(student1, student2);
            course2.addStudents(student1, student3);
            course3.addStudents(student2,student3);

            session.save(course1);
            session.save(course2);
            session.save(course3);

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
