package com.example.springhibernate.crud;

import com.example.springhibernate.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDemo {

    public static void main(String[] args) {
        System.out.println("Connecting ....");
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            System.out.println("Connection successful !!! ");
            Session session = factory.getCurrentSession();
            System.out.println("Creating new student object ...");
            Student student = new Student("Daffy", "Duck", "duffy@luv2code.com");
            session.beginTransaction();
            System.out.println("Saving the student ...");
            session.save(student);
            System.out.println("Committing ...");
            session.getTransaction().commit();

            System.out.println("Saved student. Generated ID: " + student.getId());
            session = factory.getCurrentSession();
            session.beginTransaction();
            Student myStudent = session.get(Student.class, student.getId());
            System.out.println("Read complete: " + myStudent);
            session.getTransaction().commit();

            System.out.println("Work done !!!!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
