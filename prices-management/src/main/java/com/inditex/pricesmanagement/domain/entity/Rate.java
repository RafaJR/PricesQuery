package com.inditex.pricesmanagement.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity(name = "rates")
@Table(name = "RATES")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RATE_ID", updatable = false, nullable = false)
    @JsonProperty("rateId")
    private Long rateId;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "RATE_NAME", length = 20, nullable = false)
    @JsonProperty("rateName")
    private String rateName;

    // Relaciones
    @OneToMany(mappedBy = "priceList", fetch = FetchType.LAZY)
    private Set<Price> prices;

}
