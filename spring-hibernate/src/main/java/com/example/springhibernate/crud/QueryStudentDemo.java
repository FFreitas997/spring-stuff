package com.example.springhibernate.crud;

import com.example.springhibernate.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {

    public static void main(String[] args) {
        System.out.println("Connecting ....");
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            System.out.println("Connection successful !!! ");
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            List<Student> students;

            // All students
            students = session.createQuery("from Student").getResultList();
            displayStudents(students);

            //Query where lastName = 'Doe'
            students = session.createQuery("from Student where lastName='Doe'").getResultList();
            displayStudents(students);

            //Query where lastName = 'Doe' or firstName = 'Daffy'
            students = session.createQuery("from Student where lastName='Doe' or firstName='Daffy'").getResultList();
            displayStudents(students);

            //Query where email like '%luv2code.com'
            students = session.createQuery("from Student where email like '%luv2code.com'").getResultList();
            displayStudents(students);

            session.getTransaction().commit();
            System.out.println("Work done !!!!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void displayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println("\n" + student + "\n");
        }
    }
}
