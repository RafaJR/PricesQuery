package com.inditex.pricesmanagement.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inditex.pricesmanagement.domain.enums.Currency;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "prices")
@Table(name = "PRICES", uniqueConstraints = @UniqueConstraint(columnNames = "PRICE_ID"))
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRICE_ID", updatable = false, nullable = false)
    @JsonProperty("priceId")
    private Long priceId;

    @NotNull
    @Column(name = "START_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("startDate")
    private LocalDateTime startDate;

    @NotNull
    @Column(name = "END_DATE", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @JsonProperty("endDate")
    private LocalDateTime endDate;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "CURR", nullable = false)
    @JsonProperty("currency")
    private Currency currency;

    @NotNull
    @Positive
    @Column(name = "PRICE", nullable = false, precision = 10, scale = 2)
    @JsonProperty("price")
    private BigDecimal price;

    @NotNull
    @Column(name = "PRIORITY", nullable = false)
    @JsonProperty("priority")
    private Integer priority;

    // Relaciones
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BRAND_ID", referencedColumnName = "BRAND_ID", insertable = true, updatable = true)
    @JsonProperty("brand")
    private Brand brand;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRICE_LIST", referencedColumnName = "RATE_ID", insertable = true, updatable = true)
    @JsonProperty("priceList")
    private Rate priceList;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID", insertable = true, updatable = true)
    @JsonProperty("productId")
    private Product product;

}
