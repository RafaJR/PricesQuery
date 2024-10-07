FROM maven:3.6.3-jdk-17-slim AS build
RUN mkdir /project
COPY . /project
WORKDIR /project
ARG MVN_PROFILE=local
RUN mvn clean package -P $MVN_PROFILE -DskipTests -Dhttps.protocols=TLSv1.2

FROM eclipse-temurin:11
RUN mkdir /app
COPY --from=build /project/target/*.jar /app/prices-management-0.0.1-SNAPSHOT.jar
CMD ["java", "-jar", "/app/prices-management-0.0.1-SNAPSHOT.jar"]
