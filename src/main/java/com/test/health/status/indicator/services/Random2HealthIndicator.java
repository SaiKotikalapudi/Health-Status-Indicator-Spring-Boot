package com.test.health.status.indicator.services;

import com.test.health.status.indicator.Health;
import com.test.health.status.indicator.HealthState;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.atomic.AtomicLong;

@Component
public class Random2HealthIndicator implements HealthIndicator {

    private static final Random RANDOM = new Random();

    @Override
    public String name(){
        return "Random Service 2";
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