package com.inditex.pricesmanagement.application.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.inditex.pricesmanagement.infrastructure.util.PricesManagementConstants;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class PriceQueryInputDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    @JsonFormat(pattern = PricesManagementConstants.DEFAULT_OUTPUT_DATE_FORMAT, shape = JsonFormat.Shape.STRING, timezone = PricesManagementConstants.DEFAULT_TIMEZONE)
    private LocalDateTime applicationDate;

    @NotNull
    private Long productId;

    @NotNull
    private Long brandId;

}