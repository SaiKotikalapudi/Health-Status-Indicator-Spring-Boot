package com.test.health.status.indicator;

import java.util.Map;

public class HealthStatus {

    private final String name;
    private final HealthState state;
    private final Map<String, Object> details;

    public HealthStatus(String name, Health health) {
        this.name = name;
        this.state = health.getStatus();
        this.details =health.getDetails();
    }

    public String getName() {
        return name;
    }

    public HealthState getState() {
        return state;
    }

    public Map<String, Object> getDetails() {
        return details;
    }
}
