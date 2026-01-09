FROM eclipse-temurin:17-jre-jammy
WORKDIR /app
COPY target/NextGenSolr-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app/app.jar"]# Use lightweight Java 17 runtime
FROM eclipse-temurin:17-jre-jammy

# Set working directory inside container
WORKDIR /app

# Copy the exact JAR file into container
COPY target/NextGenSolr-0.0.1-SNAPSHOT.jar app.jar

# Expose Spring Boot default port
EXPOSE 8080

# Run the Spring Boot application
ENTRYPOINT ["java","-jar","/app/app.jar"]
