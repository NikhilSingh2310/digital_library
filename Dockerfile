# Use OpenJDK 17 as base image
FROM openjdk:17-jdk-slim

# Set working directory
WORKDIR /app

# Copy Maven Wrapper and source code
COPY mvnw .
COPY .mvn .mvn
COPY pom.xml .
COPY src src

# Build application
RUN chmod +x mvnw && ./mvnw clean package -DskipTests

# Run application
CMD ["java", "-jar", "target/*.jar"]
