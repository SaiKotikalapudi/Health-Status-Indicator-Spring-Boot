package com.test.health.status.indicator.services;

import com.test.health.status.indicator.Health;

interface HealthIndicator {
     String name();
     Health health();
}
