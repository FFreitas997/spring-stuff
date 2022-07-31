package com.softinsa.udemyspring.democode.model;

import com.softinsa.udemyspring.democode.service.FortuneService;

public class BaseballCoach implements Coach {

    private final FortuneService fortuneService;

    public BaseballCoach(FortuneService service) {
        this.fortuneService = service;
    }

    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes on batting practice";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
