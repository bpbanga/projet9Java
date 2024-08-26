## This uses multi-stage build :
## https://docs.docker.com/develop/develop-images/multistage-build/

## Need to add curl to the alpine for healthcheck in docker-compose.yml file

###########################
#microservice diagnostic
###########################
# Alpine Linux with OpenJDK JRE
FROM openjdk:17-jdk-alpine
#api port
EXPOSE 9004

VOLUME /tmp

ARG JAR_FILE=target/*.jar

COPY  target/*.jar app.jar


ENTRYPOINT  [ "java", "-jar","/app.jar" ]

WORKDIR /app
