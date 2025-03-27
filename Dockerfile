# Use a lightweight JDK image
FROM eclipse-temurin:17-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file (ensure the correct name)
COPY target/*.jar app.jar

# Expose the application port
EXPOSE 8080

# Run the application with optimized JVM settings
ENTRYPOINT ["java", "-jar", "-Dspring.profiles.active=prod", "app.jar"]
