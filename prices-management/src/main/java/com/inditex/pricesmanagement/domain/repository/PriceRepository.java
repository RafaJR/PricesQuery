package com.inditex.pricesmanagement.domain.repository;

import com.inditex.pricesmanagement.domain.entity.Brand;
import com.inditex.pricesmanagement.domain.entity.Price;
import com.inditex.pricesmanagement.domain.entity.Product;
import com.inditex.pricesmanagement.domain.enums.Currency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends JpaRepository<Price, Long> {
    List<Price> findByCurrency(Currency currency);

    List<Price> findByBrand(Brand brand);

    List<Price> findByProduct(Product product);
}
