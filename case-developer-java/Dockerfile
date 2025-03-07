# Use an official OpenJDK runtime as a parent image
FROM maven:3.9.9-amazoncorretto-21-al2023 as build

# Set the working directory in the container
WORKDIR /app

# Copy the project's pom.xml and source code to the container
COPY pom.xml .
COPY src ./src

# Package the application
RUN mvn clean package -DskipTests

FROM amazoncorretto:21-alpine-jdk as run

WORKDIR /app

# Copy the packaged jar file to the container
COPY --from=build /app/target/case-developer-java-0.0.1-SNAPSHOT.jar app.jar

# Expose the port the application runs on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]