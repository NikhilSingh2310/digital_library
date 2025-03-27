# Use an official OpenJDK 21 with Maven for building
FROM maven:3.9.5-eclipse-temurin-21 AS build

# Set the working directory inside the container
WORKDIR /app

# Copy the pom.xml and download dependencies (this helps with caching)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the entire source code
COPY src ./src

# Build the application using Java 21
RUN mvn clean package -DskipTests

# Use a minimal JDK 21 image for running the app
FROM eclipse-temurin:21-jdk

# Set the working directory inside the container
WORKDIR /app

# Copy the built JAR from the previous build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
