# Use OpenJDK 17 as the base image
FROM adoptopenjdk/openjdk17:alpine-jre

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the host into the container at /app
COPY target/AJES.jar /app/AJES.jar

# Expose the port your application listens on
EXPOSE 5050

# Specify the command to run your application
CMD ["java", "-jar", "AJES.jar"]
