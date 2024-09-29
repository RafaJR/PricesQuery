# prices-management
Microservicio para la gestión de tarifas y precios de productos de cadenas de Inditex
## Table of Contents
- [Instrucciones para el arranque y ejecución del servicio](#instrucciones-para-el-arranque-y-ejecución-del-servicio)
- [Instrucciones para realización de pruebas unitarias y de integración](#instrucciones-para-realización-de-pruebas-unitarias-y-de-integración)
- 
## Instrucciones para el arranque y ejecución del servicio

### Requeriminentos de sistema
- JDK 1.17 o versión posterior.
- Maven 3.6.3 o versión posterior.
Todas las herramientas necesarias deben estar configuradas como predeterminadas en el sistema.

### Arranque del servicio
Descargar el código desde el repositorio de Github:

	https://github.com/RafaJR/PricesService.git

Una vez descargado se debe compilar el código empleando 'maven'.
Hay varios perfiles de maven habilitados con el fin de que se pueda adaptar el despliegue a un entorno de trabajo real:
    - local
    - dev
    - pro
Se asume que, al inicio, se desplegará el servicio en un entorno de desarrollo local, por lo que el perfil a utilizar sería 'local'.
Para compilar el proyecto con el perfil 'local', ejecutar uno de estos comandos desde el directorio principal del proyecto en el que se ubica el archivo 'pom.xml':
- Sin tests:

        mvn clean install -DskipTests -P local

- Con tests:

        mvn clean install -P local
La distinción "Sin tests" o "Con tests" se refiere al requerimiento de ejecutar y aprobar los tesde unitarios y de integración implementados en el servicio. Sobre estos tests se darán las explicaciones necesarias más adelante.

Una vez compilado el proyecto, se generará un archivo "prices-management-0.0.1-SNAPSHOT.jar" en la carpeta "target" del proyecto, que estará dentro del directorio principal del mismo.
Para arrancar el proyecto debemos ejecutar este archivo, lo cual puede hacerse con este comando:

	 java -jar prices-management-0.0.1-SNAPSHOT.jar

Una vez arrancado el servicio, sus funcionalidades estarán disponibles a través de los 'endpoints' que se describen más adelente.
Se recomienda, antes de comenzar a probar las funcionalidades del servicio, realizar una revisión del estado de salud del mismo para comprobar que el arranque ha sido correcto. Se puede hacer con una consulta a esta URL:
    
    http://localhost:8080/api/health
Si todo ha ido bien, la llamada devolverá una "response" de estado "HTTP 200" con un mensaje como este:
    El servicio de gestión de precios y tarifas está activo y funcionando correctamente.

También la base de datos en memoria del servicio debe haber arrancado automáticamente, las tablas del servicio deben haberse creado y los datos iniciales de prueba deben haberse cargado. Se puede comprobar el estado de la base de datos en esta URL:
    
    http://localhost:8080/h2-console/
        JDBC URL: jdbc:h2:mem:pricesmanagementdb
        User Name: admin
        * Password no necesara


## Instrucciones para realización de pruebas unitarias y de integración
Como ya se indicó en el apartado sobre el arranque del servicio, para la ejecución de todas las pruebas unitarias y de integración bastará con compilar con maven:
    
    mvn clean install -P local
También es posible ejecutar los tests por separado.