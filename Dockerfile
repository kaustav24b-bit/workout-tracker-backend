# Use an official Java 21 runtime as the base image
FROM eclipse-temurin:21-jdk-alpine

# Set the working directory inside the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml first (for dependency caching)
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# Fix executable permission on mvnw (lost on Windows)
RUN chmod +x mvnw

# Download dependencies
RUN ./mvnw dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build the application
RUN ./mvnw clean package -DskipTests

# Run the jar
ENTRYPOINT ["java", "-jar", "target/tracker-0.0.1-SNAPSHOT.jar"]