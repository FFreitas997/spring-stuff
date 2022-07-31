package com.softinsa.udemyspringannotations.democode;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService {

    private final String[] data = {
            "Beware of the wolf in sheep´s clothing",
            "Diligence is the mother of good luck",
            "The journey is the reward"
    };

    private final Random random = new Random();

    @Override
    public String getFortune() {
        return data[random.nextInt(data.length)];
    }
}
