package com.inditex.pricesmanagement.domain.service;

import com.inditex.pricesmanagement.application.dto.PriceDto;
import com.inditex.pricesmanagement.application.dto.PriceQueryInputDto;

import java.util.List;

public interface IPriceService {
    List<PriceDto> findPricesByDateProductBrand(PriceQueryInputDto queryInputDto);

    List<PriceDto> findPricesByProductBrand(PriceQueryInputDto queryInputDto);
}
