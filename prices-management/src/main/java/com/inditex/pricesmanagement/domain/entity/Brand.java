package com.inditex.pricesmanagement.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;
import java.util.Set;

@Entity(name = "brands")
@Table(name = "BRANDS", uniqueConstraints = @UniqueConstraint(columnNames = "BRAND_ID"))
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Brand {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BRAND_ID", updatable = false, nullable = false)
    @JsonProperty("brandId")
    private Long brandId;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "BRAND_NAME", length = 20, nullable = false)
    @JsonProperty("brandName")
    private String brandName;

    @NotNull
    @Column(name = "FOUNDATION_DATE", nullable = false)
    @Temporal(TemporalType.DATE)
    @JsonProperty("foundationDate")
    private LocalDate foundationDate;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "COUNTRY_OF_ORIGIN", length = 20, nullable = false)
    @JsonProperty("countryOfOrigin")
    private String countryOfOrigin;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "MARKET_SEGMENT", length = 50, nullable = false)
    @JsonProperty("marketSegment")
    private String marketSegment;

    // Relaciones
    @OneToMany(mappedBy = "brand", fetch = FetchType.LAZY)
    private Set<Price> prices;
}
