###########################
#microservice patient
###########################
# Alpine Linux with OpenJDK JRE
FROM openjdk:17-jdk-alpine
#api port
EXPOSE 9002

VOLUME /tmp

ARG JAR_FILE=target/*.jar

COPY  target/*.jar app.jar


ENTRYPOINT  [ "java", "-jar","/app.jar" ]

WORKDIR /app
