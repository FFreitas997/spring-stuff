package com.softinsa.udemyspringannotations.democode;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")){
            Coach theCoach = context.getBean("tennisCoach", Coach.class);
            System.out.println(theCoach.getDailyWorkout());
            System.out.println(theCoach.getDailyFortune());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
