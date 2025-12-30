# ------------ Stage 1: Build ------------
FROM maven:3.9.3-eclipse-temurin-17 AS builder

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

# ------------ Stage 2: Runtime ------------
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=builder /app/target/*.jar app.jar
# Expose the port the application will run on

ENTRYPOINT ["java", "-jar", "app.jar"]
