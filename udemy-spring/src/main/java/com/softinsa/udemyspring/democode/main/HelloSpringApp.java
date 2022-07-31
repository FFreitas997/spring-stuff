package com.softinsa.udemyspring.democode.main;

import com.softinsa.udemyspring.democode.model.Coach;
import com.softinsa.udemyspring.democode.model.CricketCoach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")) {
        /*  Coach theCoach = context.getBean("myCoachTrack", Coach.class);
            System.out.println(theCoach.getDailyWorkout());
            System.out.println(theCoach.getDailyFortune());*/
            CricketCoach theCoach = context.getBean("myCoachCricket", CricketCoach.class);
            System.out.println("Daily Work : " + theCoach.getDailyWorkout());
            System.out.println("Fortune : " + theCoach.getDailyFortune());
            System.out.println("Email Address : " + theCoach.getEmailAddress());
            System.out.println("Team : " + theCoach.getTeam());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
