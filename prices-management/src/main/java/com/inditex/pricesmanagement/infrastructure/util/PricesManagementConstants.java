package com.inditex.pricesmanagement.infrastructure.util;

public final class PricesManagementConstants {

    // Literales para 'responses' fijos del microservicio
    public static final String SERVICE_HEALTH_STATE = "El servicio de gestión de precios y tarifas está activo y funcionando correctamente.";

    /**
     * Constructor privado para evitar la instanciación de la clase.
     */
    private PricesManagementConstants() {
        throw new UnsupportedOperationException("Esta es una clase de constantes y no debe ser instanciada");
    }

}
