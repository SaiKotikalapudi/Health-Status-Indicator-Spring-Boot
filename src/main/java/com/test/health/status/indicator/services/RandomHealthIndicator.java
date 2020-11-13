package com.test.health.status.indicator.services;

import com.test.health.status.indicator.Health;
import com.test.health.status.indicator.HealthState;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

@Component
public class RandomHealthIndicator implements HealthIndicator {

    private static final Random RANDOM = new Random(1234567890L);

    @Override
    public String name(){
        return "Random Service";
    }

    @Override
    public Health health() {
        final HealthState[] healthStates = HealthState.values();
        final int statusInt = RANDOM.nextInt(healthStates.length);
        final HealthState healthState = healthStates[statusInt];
        final Map<String,Object> details = new HashMap<>();
        details.put("foo","bar");
        return new Health(healthState,details);
    }
}