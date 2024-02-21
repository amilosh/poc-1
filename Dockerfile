FROM openjdk:17-jdk-alpine
EXPOSE 8080
COPY build/libs/poc-1-0.0.1.jar app.jar
ENTRYPOINT ["java","-jar","app.jar"]