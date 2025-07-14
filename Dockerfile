# STEP 1: Build the JAR
FROM eclipse-temurin:21-jdk-alpine AS build
WORKDIR /app

# Copy all project files
COPY . .

# Make sure the Maven wrapper is executable
RUN chmod +x mvnw

# Build the JAR
RUN ./mvnw clean package -DskipTests

# STEP 2: Run the app
FROM eclipse-temurin:17-jdk-alpine
WORKDIR /app

# Copy the JAR built in the first stage
COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]


