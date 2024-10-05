package com.inditex.pricesmanagement.infrastructure.util;

public final class PricesManagementConstants {

    /**
     * Literales para 'responses' fijos del microservicio
     */
    // Mensaje de aviso de servicio levantado
    public static final String SERVICE_HEALTH_STATE = "El servicio de gestión de precios y tarifas está activo y funcionando correctamente.";
    /**
     * Constantes para la representación de datos
     */
    // Zona horaria para datos temporales por defecto
    public static final String DEFAULT_TIMEZONE = "Europe/Madrid";
    // Formatao de representación de salida para fechas y horas por defecto
    public static final String DEFAULT_OUTPUT_DATE_FORMAT = "yyyy-MM-dd-HH.mm.ss";

    /**
     * Constructor privado para evitar la instanciación de la clase.
     */
    private PricesManagementConstants() {
        throw new UnsupportedOperationException("Esta es una clase de constantes y no debe ser instanciada");
    }

}
