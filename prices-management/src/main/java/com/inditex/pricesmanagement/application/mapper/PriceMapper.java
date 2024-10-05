package com.inditex.pricesmanagement.application.mapper;

import com.inditex.pricesmanagement.application.dto.PriceDto;
import com.inditex.pricesmanagement.domain.entity.Brand;
import com.inditex.pricesmanagement.domain.entity.Price;
import com.inditex.pricesmanagement.domain.entity.Product;
import com.inditex.pricesmanagement.domain.entity.Rate;

import java.util.Objects;

/**
 * Clase de mapeo entre entidad Price y su respectivo DTO
 */
public class PriceMapper {

    public static PriceDto toDto(Price price) {
        if (Objects.isNull(price)) return null;

        return PriceDto.builder()
                .priceId(price.getPriceId())
                .startDate(price.getStartDate())
                .endDate(price.getEndDate())
                .currency(price.getCurrency())
                .price(price.getPrice())
                .priority(price.getPriority())
                .brandId(price.getBrand() != null ? price.getBrand().getBrandId() : null)
                .priceList(price.getPriceList() != null ? price.getPriceList().getRateId() : null)
                .productId(price.getProduct() != null ? price.getProduct().getProductId() : null)
                .build();
    }

    public static Price toEntity(PriceDto priceDto) {
        if (Objects.isNull(priceDto)) return null;

        Price price = Price.builder()
                .priceId(priceDto.getPriceId())
                .startDate(priceDto.getStartDate())
                .endDate(priceDto.getEndDate())
                .currency(priceDto.getCurrency())
                .price(priceDto.getPrice())
                .priority(priceDto.getPriority())
                .build();

        if (Objects.nonNull(priceDto.getBrandId())) {
            Brand brand = Brand.builder()
                    .brandId(priceDto.getBrandId())
                    .build();
            price.setBrand(brand);
        }

        if (Objects.nonNull(priceDto.getPriceList())) {
            Rate rate = Rate.builder()
                    .rateId(priceDto.getPriceList())
                    .build();
            price.setPriceList(rate);
        }

        if (Objects.nonNull(priceDto.getProductId())) {
            Product product = Product.builder()
                    .productId(priceDto.getProductId())
                    .build();
            price.setProduct(product);
        }

        return price;
    }
}
