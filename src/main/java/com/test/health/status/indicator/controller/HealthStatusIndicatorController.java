package com.test.health.status.indicator.controller;

import com.test.health.status.indicator.HealthState;
import com.test.health.status.indicator.HealthStatus;
import com.test.health.status.indicator.services.HealthIndicatorService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/health/status")
class HealthStatusIndicatorController {

    private final HealthIndicatorService healthIndicatorService;

    HealthStatusIndicatorController(HealthIndicatorService healthIndicatorService) {
        this.healthIndicatorService = healthIndicatorService;
    }

    @GetMapping
    List<HealthStatus> healthStatuses(){
        return healthIndicatorService.getHealthStatuses();
    }

    @GetMapping("/{name}")
    HealthStatus healthStatuses(@PathParam("name") final String name ){
        return healthIndicatorService.getHealthStatus(name);
    }

    @GetMapping("/names")
    List<String> names(){
        return healthIndicatorService.getAllHealthNames();
    }

}
