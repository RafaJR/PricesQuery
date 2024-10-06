package com.inditex.pricesmanagement.infrastructure.controller;

import com.inditex.pricesmanagement.application.dto.PriceDto;
import com.inditex.pricesmanagement.application.dto.PriceQueryInputDto;
import com.inditex.pricesmanagement.application.dto.commons.ApiResponseDto;
import com.inditex.pricesmanagement.domain.service.PriceServiceImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/prices")
public class PriceController {

    private final PriceServiceImpl priceService;

    @Autowired
    public PriceController(PriceServiceImpl priceService) {
        this.priceService = priceService;
    }

    @PostMapping("/search")
    public ResponseEntity<ApiResponseDto<List<PriceDto>>> searchPrices(@Valid @RequestBody PriceQueryInputDto queryInputDto) {
        try {
            List<PriceDto> prices = priceService.findPricesByDateProductBrand(queryInputDto);

            if (prices != null && !prices.isEmpty()) {
                ApiResponseDto<List<PriceDto>> response = new ApiResponseDto<>(
                        HttpStatus.OK.name(),
                        HttpStatus.OK.value(),
                        "Data retrieved successfully",
                        true,
                        prices
                );
                return ResponseEntity.ok(response);
            } else {
                ApiResponseDto<List<PriceDto>> response = new ApiResponseDto<>(
                        HttpStatus.NOT_FOUND.name(),
                        HttpStatus.NOT_FOUND.value(),
                        "Resource not found",
                        false,
                        null
                );
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
            }
        } catch (Exception e) {
            ApiResponseDto<List<PriceDto>> response = new ApiResponseDto<>(
                    HttpStatus.INTERNAL_SERVER_ERROR.name(),
                    HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    "An error occurred while processing the request",
                    false,
                    null
            );
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
