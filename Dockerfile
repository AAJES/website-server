FROM openjdk:17-alpine
ADD target/AJES.jar AJES.jar
EXPOSE 9090
ENTRYPOINT ["java","-jar","AJES.jar"]