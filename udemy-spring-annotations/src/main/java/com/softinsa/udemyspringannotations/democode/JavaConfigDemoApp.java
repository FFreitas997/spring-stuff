package com.softinsa.udemyspringannotations.democode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

    public static void main(String[] args) {
        try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class)){
            /*

            Coach theCoach = context.getBean("tennisCoach", Coach.class);
            System.out.println(theCoach.getDailyWorkout());
            System.out.println(theCoach.getDailyFortune());

            Coach swimCoach = context.getBean("swimCoach", SwimCoach.class);
            System.out.println(swimCoach.getDailyFortune());
            System.out.println(swimCoach.getDailyWorkout());

            */
            SwimCoach swimCoach = context.getBean("swimCoach", SwimCoach.class);
            System.out.println(swimCoach.getDailyFortune());
            System.out.println(swimCoach.getDailyWorkout());
            System.out.println("Email: " + swimCoach.getEmail());
            System.out.println("Team: " + swimCoach.getTeam());
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
