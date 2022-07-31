package com.softinsa.udemyspring.democode.main;

import com.softinsa.udemyspring.democode.model.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycleDemoApp {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml")) {
            Coach theCoach = context.getBean("myCoach", Coach.class);
            System.out.println(theCoach.getDailyWorkout());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
