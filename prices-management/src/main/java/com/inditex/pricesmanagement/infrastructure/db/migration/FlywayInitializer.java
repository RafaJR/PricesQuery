package com.inditex.pricesmanagement.infrastructure.db.migration;

import lombok.extern.slf4j.Slf4j;
import org.flywaydb.core.Flyway;
import org.flywaydb.core.api.MigrationInfo;
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

    private final ConfigurableEnvironment environment;

    @Autowired
    public FlywayInitializer(ConfigurableEnvironment environment) {
        this.environment = environment;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {

        FlywayInitializer.log.info("Iniciando la configuración de 'flyway-migrate' para la carga de datos.");

        Flyway reconfiguredFlyway = Flyway.configure()
                .dataSource(
                        environment.getProperty("spring.datasource.url"),
                        environment.getProperty("spring.datasource.username"),
                        environment.getProperty("spring.datasource.password"))
                .locations(environment.getProperty("spring.flyway.locations"))
                .baselineOnMigrate(true)
                .load();

        FlywayInitializer.log.info("Se van a carcar estos archivos de datos: {}",
                Arrays.stream(reconfiguredFlyway.info().pending())
                        .map(MigrationInfo::getScript).collect(Collectors.joining(",")));

        reconfiguredFlyway.migrate();

        FlywayInitializer.log.info("Migraciones de Flyway completadas.");
    }
}