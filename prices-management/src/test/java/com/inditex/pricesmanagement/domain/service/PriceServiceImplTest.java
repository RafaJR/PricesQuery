package com.inditex.pricesmanagement.domain.service;

import com.inditex.pricesmanagement.application.dto.PriceDto;
import com.inditex.pricesmanagement.application.dto.PriceQueryInputDto;
import com.inditex.pricesmanagement.domain.entity.Price;
import com.inditex.pricesmanagement.domain.repository.PriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class PriceServiceImplTest {

    @Mock
    private PriceRepository priceRepository;

    @InjectMocks
    private PriceServiceImpl priceService;

    @Test
    void testFindPricesByDateProductBrand1() {
        // Configura el comportamiento del mock para que devuelva una lista de precios cuando se llame al método
        List<Price> mockPrices = List.of(new Price(/*inicializa según tu clase Price*/));
        when(priceRepository.findPricesByApplicationDateProductIdAndBrandId(
                any(LocalDateTime.class), anyLong(), anyLong())).thenReturn(mockPrices);

        // Crea un objeto PriceQueryInputDto dentro del método de prueba
        PriceQueryInputDto specificQueryInputDto = PriceQueryInputDto.builder()
                .applicationDate(LocalDateTime.of(2020, 6, 14, 10, 0))
                .productId(35455L)
                .brandId(1L)
                .build();

        // Llama al método con el DTO creado
        List<PriceDto> prices = priceService.findPricesByDateProductBrand(specificQueryInputDto);

        // Verifica que el resultado no es nulo ni una lista vacía
        assertNotNull(prices);
        assertFalse(prices.isEmpty());

        // Verifica que el repositorio fue llamado con los parámetros correctos
        verify(priceRepository).findPricesByApplicationDateProductIdAndBrandId(
                eq(specificQueryInputDto.getApplicationDate()), eq(specificQueryInputDto.getProductId()),
                eq(specificQueryInputDto.getBrandId()));
    }

    @Test
    void testFindPricesByProductBrand1() {
        // Configura el comportamiento del mock para que devuelva una lista de precios cuando se llame al método
        List<Price> mockPrices = List.of(new Price(/*inicializa según tu clase Price*/));
        when(priceRepository.findPricesByProductIdAndBrandId(anyLong(), anyLong())).thenReturn(mockPrices);

        // Crea un objeto PriceQueryInputDto dentro del método de prueba
        PriceQueryInputDto specificQueryInputDto = PriceQueryInputDto.builder()
                .productId(35455L)
                .brandId(1L)
                .build();

        // Llama al método con el DTO creado
        List<PriceDto> prices = priceService.findPricesByProductBrand(specificQueryInputDto);

        // Verifica que el resultado no es nulo ni una lista vacía
        assertNotNull(prices);
        assertFalse(prices.isEmpty());

        // Verifica que el repositorio fue llamado con los parámetros correctos
        verify(priceRepository).findPricesByProductIdAndBrandId(specificQueryInputDto.getProductId(), specificQueryInputDto.getBrandId());
    }
}
