###########################
#microservice note
###########################
# Alpine Linux with OpenJDK JRE
FROM openjdk:17-jdk-alpine
#api port
EXPOSE 9005

VOLUME /tmp

ARG JAR_FILE=target/*.jar

COPY  target/*.jar app.jar

# ADD target/patient-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT  [ "java", "-jar","/app.jar" ]

WORKDIR /app
