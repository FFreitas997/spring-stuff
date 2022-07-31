package com.softinsa.udemyspringannotations.democode;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

    public static void main(String[] args) {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml")){
            Coach theCoach = context.getBean("tennisCoach", Coach.class);
            Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
            boolean result = (theCoach == alphaCoach);
            System.out.println("\nPointing to the same object: " + result);
            System.out.println("\nMemory location for theCoach: " + theCoach);
            System.out.println("\nMemory Location for alphaCoach" + alphaCoach + "\n");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
