package com.test.health.status.indicator.services;

import com.test.health.status.indicator.Health;
import com.test.health.status.indicator.HealthStatus;
import org.springframework.stereotype.Component;

import java.beans.ConstructorProperties;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class HealthIndicatorService {

    private final Map<String, HealthIndicator> healthIndicatorMap;

     HealthIndicatorService(List<HealthIndicator> healthIndicators) {
         this.healthIndicatorMap = new HashMap<>();
         for (HealthIndicator healthIndicator: healthIndicators){
             HealthIndicator dup = this.healthIndicatorMap.put(healthIndicator.name(), healthIndicator);
             if (dup != null) {
                 throw new IllegalStateException(
                         String.format(
                                 "%s name has 2 indicators: %s %s",
                                 dup.name(),
                                 dup.getClass().getName(),
                                 healthIndicator.getClass().getName()
                         )
                 );
             }
         }
         healthIndicators.forEach(
                healthIndicator -> {
                });
    }

    public List<HealthStatus> getHealthStatuses(){
       return healthIndicatorMap.values().stream()
                .map(healthIndicator ->
                    new HealthStatus(healthIndicator.name(),healthIndicator.health())
                ).collect(Collectors.toList());
    }

    public HealthStatus getHealthStatus(final String name){
         HealthIndicator healthIndicator = healthIndicatorMap.get(name);
         return new HealthStatus(healthIndicator.name(),healthIndicator.health());
    }

    public List<String> getAllHealthNames(){
         return new ArrayList<>(healthIndicatorMap.keySet());
    }

    public List<Health> getAllHealth(){
         return healthIndicatorMap.values().stream()
                 .map(HealthIndicator::health)
                 .collect(Collectors.toList());
    }

    public Health getHealth(String name){
        HealthIndicator indicator = healthIndicatorMap.get(name);
        if (indicator == null){
            return null;
        }else {
            return indicator.health();
        }
    }
}
