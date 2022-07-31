package com.example.springhibernate.crud;

import com.example.springhibernate.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteStudentDemo {

    /**
     * Open database connection using Hibernate and Student class for mapping
     */
    public static void main(String[] args) {
        System.out.println("Connecting ....");
        try (SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory()) {
            System.out.println("Connection successful");
            Session session = factory.getCurrentSession();
            session.beginTransaction();

            int studentID;

            studentID = 1;
            Student student = session.get(Student.class, studentID);
            System.out.println(" \nDeleting student: " + student + "\n");
            session.delete(student);


            studentID = 2;
            System.out.println(" \nDeleting student with id 2 \n");
            String query = String.format("delete from Student where id = %d", studentID);
            session.createQuery(query).executeUpdate();

            System.out.println("Committing ...");
            session.getTransaction().commit();
            System.out.println("Work done !!!!");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
