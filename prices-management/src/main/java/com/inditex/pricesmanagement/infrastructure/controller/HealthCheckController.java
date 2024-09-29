package com.inditex.pricesmanagement.infrastructure.controller;

import com.inditex.pricesmanagement.infrastructure.util.PricesManagementConstants;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<String> checkHealth() {
        return ResponseEntity.ok(PricesManagementConstants.SERVICE_HEALTH_STATE);
    }
}
