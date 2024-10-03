package com.inditex.pricesmanagement.domain.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.Set;

@Entity(name = "products")
@Table(name = "PRODUCTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PRODUCT_ID", updatable = false, nullable = false)
    @JsonProperty("productId")
    private Long productId;

    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "PRODUCT_NAME", length = 20, nullable = false)
    @JsonProperty("productName")
    private String productName;

    // Relaciones
    @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
    private Set<Price> prices;

}
