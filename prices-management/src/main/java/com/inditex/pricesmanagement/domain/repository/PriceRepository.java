package com.inditex.pricesmanagement.domain.repository;

import com.inditex.pricesmanagement.domain.entity.Price;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {

    @Query("SELECT p FROM prices p WHERE " +
            ":applicationDate BETWEEN p.startDate AND p.endDate AND " +
            "p.product.productId = :productId AND " +
            "p.brand.brandId = :brandId")
    List<Price> findPricesByApplicationDateProductIdAndBrandId(
            @Param("applicationDate") LocalDateTime applicationDate,
            @Param("productId") Long productId,
            @Param("brandId") Long brandId);

//    findByStartDateLessThanEqualAndEndDateGreaterThanEqualAndProduct_ProductIdAndBrand_BrandId

    @Query("SELECT p FROM prices p WHERE " +
            "p.product.productId = :productId AND " +
            "p.brand.brandId = :brandId")
    List<Price> findPricesByProductIdAndBrandId(
            @Param("productId") Long productId,
            @Param("brandId") Long brandId);

}
