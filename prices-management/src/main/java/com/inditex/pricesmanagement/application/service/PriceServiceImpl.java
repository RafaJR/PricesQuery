package com.inditex.pricesmanagement.application.service;

import com.inditex.pricesmanagement.application.dto.PriceDto;
import com.inditex.pricesmanagement.application.dto.PriceQueryInputDto;
import com.inditex.pricesmanagement.application.mapper.PriceMapper;
import com.inditex.pricesmanagement.domain.entity.Price;
import com.inditex.pricesmanagement.domain.repository.PriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PriceServiceImpl implements IPriceService {

    private final PriceRepository priceRepository;

    @Autowired
    public PriceServiceImpl(PriceRepository priceRepository) {
        this.priceRepository = priceRepository;
    }

    @Override
    public List<PriceDto> findPricesByDateProductBrand(PriceQueryInputDto queryInputDto) {
        LocalDateTime applicationDate = queryInputDto.getApplicationDate();
        Long productId = queryInputDto.getProductId();
        Long brandId = queryInputDto.getBrandId();

        List<Price> priceEntities = priceRepository.findPricesByApplicationDateProductIdAndBrandId(
                applicationDate, productId, brandId);

        return priceEntities.stream()
                .map(PriceMapper::toDto)
                .toList();
    }

    @Override
    public List<PriceDto> findPricesByProductBrand(PriceQueryInputDto queryInputDto) {

        Long productId = queryInputDto.getProductId();
        Long brandId = queryInputDto.getBrandId();

        List<Price> priceEntities = priceRepository.findPricesByProductIdAndBrandId(
                productId, brandId);

        return priceEntities.stream()
                .map(PriceMapper::toDto)
                .toList();
    }
}
