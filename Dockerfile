# Java 22 
FROM eclipse-temurin:22-jdk

# Set working directory
WORKDIR /app

# Copy project files
COPY . .

# Build the application
RUN ./mvnw clean package -DskipTests

# Expose Spring Boot port
EXPOSE 8080

# Run the Spring Boot app
CMD ["java", "-jar", "target/*.jar"]
