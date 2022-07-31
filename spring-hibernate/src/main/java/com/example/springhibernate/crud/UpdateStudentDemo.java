package com.example.springhibernate.crud;

import com.example.springhibernate.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDemo {

    public static void main(String[] args) {
        System.out.println("Connecting ....");
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            System.out.println("Connection successful !!! ");

            Session session = factory.getCurrentSession();
            session.beginTransaction();
            // Update student with first name scooby where ID is 1
            int studentID = 1;
            Student student = session.get(Student.class, studentID);
            student.setFirstName("Scooby");
            session.getTransaction().commit();

            session = factory.getCurrentSession();
            session.beginTransaction();
            // Update email for all students
            session.createQuery("update Student set email='foo@gmail.com'")
                    .executeUpdate();
            session.getTransaction().commit();

            System.out.println("Work done !!!!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
