package com.inditex.pricesmanagement.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.inditex.pricesmanagement.domain.enums.Currency;
import com.inditex.pricesmanagement.infrastructure.util.PricesManagementConstants;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PriceDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long priceId;

    @JsonFormat(pattern = PricesManagementConstants.DEFAULT_OUTPUT_DATE_FORMAT, shape = JsonFormat.Shape.STRING, timezone = PricesManagementConstants.DEFAULT_TIMEZONE)
    private LocalDateTime startDate;

    @JsonFormat(pattern = PricesManagementConstants.DEFAULT_OUTPUT_DATE_FORMAT, shape = JsonFormat.Shape.STRING, timezone = PricesManagementConstants.DEFAULT_TIMEZONE)
    private LocalDateTime endDate;

    private Currency currency;

    @Positive
    private BigDecimal price;

    private Integer priority;

    private Long brandId;

    private Long priceList;

    private Long productId;
}