package com.softinsa.udemyspringannotations.democode;

import org.springframework.beans.factory.annotation.Value;
public class SwimCoach implements Coach{

    private final FortuneService fortuneService;
    @Value("${config.emailAddress}")
    private String email;
    @Value("${config.team}")
    private String team;

    public SwimCoach(FortuneService fortuneService){
        this.fortuneService = fortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 1000 meters as a warm up.";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getTeam() {
        return team;
    }

    public String getEmail() {
        return email;
    }
}
