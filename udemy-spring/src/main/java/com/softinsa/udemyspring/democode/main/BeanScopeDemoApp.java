package com.softinsa.udemyspring.democode.main;

import com.softinsa.udemyspring.democode.model.Coach;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml")) {
            Coach theCoach = context.getBean("myCoach", Coach.class);
            Coach alphaCoach = context.getBean("myCoach", Coach.class);
            boolean result = theCoach == alphaCoach;
            System.out.println("\n Pointing to the same object : " + result);
            System.out.println("\n Memory location for theCoach : " + theCoach);
            System.out.println("\n Memory location for alphaCoach : " + alphaCoach + "\n");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
