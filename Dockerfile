# Use the official OpenJDK 11 image as a base
FROM openjdk:11

# Set the working directory inside the container
WORKDIR /app

# Copy the packaged Spring Boot application JAR file into the container
COPY .mvn/wrapper/maven-wrapper.jar /app/

# Expose the port your application runs on
EXPOSE 5050

# Set the entry point to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "AJES.jar"]
