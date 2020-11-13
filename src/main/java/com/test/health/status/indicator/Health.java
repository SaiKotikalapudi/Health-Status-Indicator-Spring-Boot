package com.test.health.status.indicator;

import java.util.Map;

public class Health {
    private final HealthState Status;
    private final Map<String,Object> details;

    public Health(HealthState status, Map<String, Object> details) {
        Status = status;
        this.details = details;
    }

    public HealthState getStatus() {
        return Status;
    }

    public Map<String, Object> getDetails() {
        return details;
    }
}
