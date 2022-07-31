package com.example.springhibernate.crud;

import com.example.springhibernate.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {

    public static void main(String[] args) {
        System.out.println("Connecting ....");
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            System.out.println("| Connection successful !!! |");
            Session session = factory.getCurrentSession();
            System.out.println("Creating three new student object ...");
            Student student1 = new Student("John", "Doe", "john@luv2code.com");
            Student student2 = new Student("Mary", "Public", "mary@luv2code.com");
            Student student3 = new Student("Bonita", "Applebum", "bonita@luv2code.com");
            session.beginTransaction();
            System.out.println("Saving the students ...");
            session.save(student1);
            session.save(student2);
            session.save(student3);
            System.out.println("Committing ...");
            session.getTransaction().commit();
            System.out.println("Work done !!!!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
