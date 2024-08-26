# ## This uses multi-stage build :
# ## https://docs.docker.com/develop/develop-images/multistage-build/

# # Stage de construction pour le microservice Patient
# FROM openjdk:17-jdk-alpine AS patient
# WORKDIR /app
# COPY patient/target/patient-1.0-SNAPSHOT.jar /app/patient.jar
# EXPOSE 9002
# ENTRYPOINT ["java", "-jar", "/app/patient.jar"]

# # Stage de construction pour le microservice Note
# FROM openjdk:17-jdk-alpine AS note
# WORKDIR /app
# COPY note/target/note-1.0-SNAPSHOT.jar /app/note.jar
# EXPOSE 9005
# ENTRYPOINT ["java", "-jar", "/app/note.jar"]

# # Stage de construction pour le microservice Gateway
# FROM openjdk:17-jdk-alpine AS gateway
# WORKDIR /app
# COPY gateway/target/gateway-1.0-SNAPSHOT.jar /app/gateway.jar
# EXPOSE 9003
# ENTRYPOINT ["java", "-jar", "/app/gateway.jar"]