package com.inditex.pricesmanagement.infrastructure.controller;

import com.inditex.pricesmanagement.application.dto.PriceDto;
import com.inditex.pricesmanagement.application.dto.commons.ApiResponseDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@TestPropertySource(locations = "classpath:application-test.yml")
@Sql(scripts = "/db/migration/InitDataChargeTest.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Slf4j
public class PriceControllerIntegrationTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Value("${server.port}")
    private String serverPort;

    // Test 1: petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    public void searchPrices_ShouldReturnValidResponse1() {
        String url = String.format("http://localhost:%s/api/prices/search", serverPort);

        // Configuración de la solicitud
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        final String requestBody = "{ \"applicationDate\": \"2020-06-14-10.00.00\", \"productId\": 35455, \"brandId\": 1 }";
        log.info("Prueba de integración de consulta de precios con este 'body': \n{}", requestBody);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // Comprueba que no se lanzan excepciones en el procesamiento de la llamada
        assertThatNoException().isThrownBy(() -> restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<>() {
                }
        ));

        // Envía solicitud efectiva al endpoint
        ResponseEntity<ApiResponseDto<List<PriceDto>>> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<>() {
                }
        );

        // Validación de la respuesta
        assertThat(response).isNotNull();
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().isSuccess()).isTrue();
        assertThat(((List) response.getBody().getData())).isNotEmpty();
    }

    // Test 2: petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    public void searchPrices_ShouldReturnValidResponse2() {
        String url = String.format("http://localhost:%s/api/prices/search", serverPort);

        // Configuración de la solicitud
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        final String requestBody = "{ \"applicationDate\": \"2020-06-14-16.00.00\", \"productId\": 35455, \"brandId\": 1 }";
        log.info("Prueba de integración de consulta de precios con este 'body': \n{}", requestBody);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // Comprueba que no se lanzan excepciones en el procesamiento de la llamada
        assertThatNoException().isThrownBy(() -> restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<>() {
                }
        ));

        // Envía solicitud efectiva al endpoint
        ResponseEntity<ApiResponseDto<List<PriceDto>>> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<>() {
                }
        );

        // Validación de la respuesta
        assertThat(response).isNotNull();
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().isSuccess()).isTrue();
        assertThat(((List) response.getBody().getData())).isNotEmpty();
    }

    // Test 3: petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
    @Test
    public void searchPrices_ShouldReturnValidResponse3() {
        String url = String.format("http://localhost:%s/api/prices/search", serverPort);

        // Configuración de la solicitud
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        final String requestBody = "{ \"applicationDate\": \"2020-06-14-21.00.00\", \"productId\": 35455, \"brandId\": 1 }";
        log.info("Prueba de integración de consulta de precios con este 'body': \n{}", requestBody);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // Comprueba que no se lanzan excepciones en el procesamiento de la llamada
        assertThatNoException().isThrownBy(() -> restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<>() {
                }
        ));

        // Envía solicitud efectiva al endpoint
        ResponseEntity<ApiResponseDto<List<PriceDto>>> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<>() {
                }
        );

        // Validación de la respuesta
        assertThat(response).isNotNull();
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().isSuccess()).isTrue();
        assertThat(((List) response.getBody().getData())).isNotEmpty();
    }

    // Test 4: petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
    @Test
    public void searchPrices_ShouldReturnValidResponse4() {
        String url = String.format("http://localhost:%s/api/prices/search", serverPort);

        // Configuración de la solicitud
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        final String requestBody = "{ \"applicationDate\": \"2020-06-15-10.00.00\", \"productId\": 35455, \"brandId\": 1 }";
        log.info("Prueba de integración de consulta de precios con este 'body': \n{}", requestBody);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // Comprueba que no se lanzan excepciones en el procesamiento de la llamada
        assertThatNoException().isThrownBy(() -> restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<>() {
                }
        ));

        // Envía solicitud efectiva al endpoint
        ResponseEntity<ApiResponseDto<List<PriceDto>>> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<>() {
                }
        );

        // Validación de la respuesta
        assertThat(response).isNotNull();
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().isSuccess()).isTrue();
        assertThat(((List) response.getBody().getData())).isNotEmpty();
    }

    // Test 5: petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
    @Test
    public void searchPrices_ShouldReturnValidResponse5() {
        String url = String.format("http://localhost:%s/api/prices/search", serverPort);

        // Configuración de la solicitud
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        final String requestBody = "{ \"applicationDate\": \"2020-06-16-21.00.00\", \"productId\": 35455, \"brandId\": 1 }";
        log.info("Prueba de integración de consulta de precios con este 'body': \n{}", requestBody);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // Comprueba que no se lanzan excepciones en el procesamiento de la llamada
        assertThatNoException().isThrownBy(() -> restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<>() {
                }
        ));

        // Envía solicitud efectiva al endpoint
        ResponseEntity<ApiResponseDto<List<PriceDto>>> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<>() {
                }
        );

        // Validación de la respuesta
        assertThat(response).isNotNull();
        assertThat(response.getStatusCodeValue()).isEqualTo(200);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().isSuccess()).isTrue();
        assertThat(((List) response.getBody().getData())).isNotEmpty();
    }


    // Test 6: Consulta sin resultados
    @Test
    public void searchPrices_ShouldReturnValidResponse6() {
        String url = String.format("http://localhost:%s/api/prices/search", serverPort);

        // Configuración de la solicitud
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        final String requestBody = "{ \"applicationDate\": \"2021-06-16-21.00.00\", \"productId\": 35455, \"brandId\": 1 }";
        log.info("Prueba de integración de consulta de precios con este 'body': \n{}", requestBody);
        HttpEntity<String> entity = new HttpEntity<>(requestBody, headers);

        // Comprueba que no se lanzan excepciones en el procesamiento de la llamada
        assertThatNoException().isThrownBy(() -> restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<>() {
                }
        ));

        // Envía solicitud efectiva al endpoint
        ResponseEntity<ApiResponseDto<List<PriceDto>>> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                entity,
                new ParameterizedTypeReference<>() {
                }
        );

        // Validación de la respuesta
        assertThat(response).isNotNull();
        assertThat(response.getStatusCodeValue()).isEqualTo(404);
        assertThat(response.getBody()).isNotNull();
        assertThat(response.getBody().isSuccess()).isFalse();
        assertThat(((List) response.getBody().getData())).isNull();
    }

    @TestConfiguration
    public static class TestConfig {

        @Bean
        public TestRestTemplate testRestTemplate() {
            return new TestRestTemplate();
        }
    }
}