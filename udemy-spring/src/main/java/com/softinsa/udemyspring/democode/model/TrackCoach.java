package com.softinsa.udemyspring.democode.model;

import com.softinsa.udemyspring.democode.service.FortuneService;

public class TrackCoach implements Coach {

    private final FortuneService fortuneService;

    public TrackCoach(FortuneService service) {
        this.fortuneService = service;
    }

    public void onInit() {
        System.out.println("TrackCoach: inside method on init bean");
    }

    public void onDestroy() {
        System.out.println("TrackCoach: inside method on destroy bean");
    }

    @Override
    public String getDailyWorkout() {
        return "Run a hard 5k";
    }

    @Override
    public String getDailyFortune() {
        return String.format("Just Do It: %s", fortuneService.getFortune());
    }
}
