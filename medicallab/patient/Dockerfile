# ###########################
# #microservice patient
# ###########################

##########################
# Étape de Build
# ##########################
# Utiliser une image Maven officielle avec JDK 17 pour la construction
FROM maven:3.8.7-eclipse-temurin-17 AS build

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Copier le fichier POM spécifique au service patient
COPY pom.xml pom.xml

# Télécharger les dépendances Maven
RUN mvn dependency:go-offline -B

# Copier le reste des fichiers du projet
COPY src ./src

# Construire le projet avec Maven
RUN mvn clean install -DskipTests

###########################
# Étape d'exécution
###########################
# Alpine Linux avec OpenJDK JRE
FROM openjdk:17-jdk-alpine

# API port
EXPOSE 9002

# Créer un volume temporaire
VOLUME /tmp

# Copier le fichier JAR généré par Maven depuis l'étape précédente
COPY --from=build /app/target/*.jar /app/app.jar

# Définir le répertoire de travail dans le conteneur
WORKDIR /app

# Définir l'entrypoint
ENTRYPOINT ["java", "-jar", "/app/app.jar"]

