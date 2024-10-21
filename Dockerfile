# Etapa 1: Construcción de la aplicación
FROM gradle:7.6.0-jdk17 AS build
WORKDIR /app

# Copiar los archivos de Gradle y el código fuente de la aplicación
COPY build.gradle settings.gradle /app/
COPY src /app/src

# Construir la aplicación
RUN gradle build --no-daemon

# Etapa 2: Imagen final
FROM eclipse-temurin:17-jdk-jammy

# Crear un directorio para la aplicación
WORKDIR /app

# Copiar el JAR generado de la primera etapa
COPY --from=build /app/build/libs/*.jar /app/app.jar

# Exponer el puerto en el que se ejecuta la aplicación Spring Boot (8080 por defecto)
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/app.jar"]
