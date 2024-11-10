# Etapa 1: Construcción
FROM gradle:7.6.0-jdk17 AS builder
WORKDIR /app

COPY build.gradle settings.gradle /app/

RUN gradle build --no-daemon || return 0

COPY . /app

RUN gradle build --no-daemon

FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

COPY --from=builder /app/build/libs/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
