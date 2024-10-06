package com.inditex.pricesmanagement.infrastructure.controller;

import com.inditex.pricesmanagement.application.dto.commons.ApiResponseDto;
import com.inditex.pricesmanagement.infrastructure.util.PricesManagementConstants;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthCheckController {

    @GetMapping
    public ResponseEntity<ApiResponseDto<String>> checkHealth() {

        return ResponseEntity.ok(ApiResponseDto.<String>builder()
                .status(HttpStatus.OK.name())
                .statusCode(HttpStatus.OK.value())
                .message(PricesManagementConstants.SERVICE_HEALTH_HTTP_MESSAGE)
                .data(PricesManagementConstants.SERVICE_HEALTH_STATE)
                .success(true)
                .build());
    }
}
