package com.example.springhibernate;

import com.example.springhibernate.student.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

@SpringBootApplication
public class SpringHibernateApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringHibernateApplication.class, args);
    }

    /**
     * @param connectionURL connection url of database
     *                      template: jdbc:postgresql://{host}:{port}/{database name}
     * @param username      username associated with the database
     * @param password      username password
     * @return open connection to database mention in connectionURL
     * @author FFreitas
     * Open database connection using JDBC
     */
    public static Connection openConnectionJDBC(String connectionURL, String username, String password) {
        System.out.println("Connect to database: " + connectionURL);
        System.out.println("Connecting ....");
        try (Connection myConn = DriverManager.getConnection(connectionURL, username, password)) {
            System.out.println("| Connection successful !!! |");
            return myConn;
        } catch (SQLException exception) {
            System.out.println(exception.getMessage());
            return null;
        }
    }
}
