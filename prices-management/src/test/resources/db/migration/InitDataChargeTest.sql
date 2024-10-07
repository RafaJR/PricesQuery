-- Carga de datos iniciales de productos
MERGE INTO PRODUCTS (PRODUCT_ID, PRODUCT_NAME) KEY (PRODUCT_ID)
VALUES 
  (35455, 'Camiseta Básica'), 
  (1, 'Pantalón Chino'), 
  (2, 'Chaqueta Denim');

-- Carga de datos iniciales de tarifas
MERGE INTO RATES (RATE_ID, RATE_NAME) KEY (RATE_ID)
VALUES 
  (1, 'Tarifa Moda Premium'), 
  (2, 'Descuento Temporada'), 
  (3, 'Tarifa Colección Lux'), 
  (4, 'Precio Venta Flash');

-- Carga de datos iniciales de marcas
MERGE INTO BRANDS (BRAND_ID, BRAND_NAME, FOUNDATION_DATE, COUNTRY_OF_ORIGIN, MARKET_SEGMENT) KEY (BRAND_ID)
VALUES 
  (1, 'ZARA', '1974-05-24', 'España', 'Moda y Accesorios'), 
  (2, 'PULL&BEAR', '1991-09-01', 'España', 'Moda Adolescente'), 
  (3, 'MASSIMO DUTTI', '1985-11-23', 'España', 'Moda y Accesorios de Lujo'), 
  (4, 'BERSHKA', '1998-04-15', 'España', 'Moda Juvenil');

-- Migración de inserción inicial para la tabla PRICES
MERGE INTO PRICES (PRICE_ID, START_DATE, END_DATE, CURR, PRICE, PRIORITY, BRAND_ID, PRICE_LIST, PRODUCT_ID) KEY (PRICE_ID)
VALUES 
  (1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 'EUR', 35.50, 0, 1, 1, 35455), 
  (2, '2020-06-14 15:00:00', '2020-06-14 18:30:00', 'EUR', 25.45, 1, 1, 2, 35455), 
  (3, '2020-06-15 00:00:00', '2020-06-15 11:00:00', 'EUR', 30.50, 1, 1, 3, 35455), 
  (4, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 'EUR', 38.95, 1, 1, 4, 35455);
