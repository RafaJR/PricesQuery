package com.inditex.pricesmanagement.infrastructure.config;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.stream.Collectors;

@Component
@Slf4j
public class FlywayInitializer implements ApplicationListener<ApplicationReadyEvent> {

    @Autowired
    private ConfigurableEnvironment environment;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        FlywayInitializer.log.info("Iniciando el cambio de perfil a 'flyway-migrate' para la carga de datos.\n" +
                environment.getProperty("spring.flyway.locations"));

        // Cambiar al perfil flyway-migrate para realizar las migraciones
        //environment.setActiveProfiles("flyway-migrate");

        // Reconfigurar Flyway con el nuevo perfil
        Flyway reconfiguredFlyway = Flyway.configure()
                .dataSource("jdbc:h2:mem:pricesmanagementdb", "admin", "")
                .locations("classpath:db/migration")
                .baselineOnMigrate(true)
                .load();

        FlywayInitializer.log.info("Se van a carcar estos archivos de datos: {}",
                Arrays.stream(reconfiguredFlyway.info().pending())
                        .map(script -> script.getScript()).collect(Collectors.joining(",")));

        // Migrar la base de datos
        //reconfiguredFlyway.baseline();
        reconfiguredFlyway.migrate();

        FlywayInitializer.log.info("Migraciones de Flyway completadas.");
    }
}