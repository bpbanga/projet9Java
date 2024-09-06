# projet9Java MEDICALLAB

## About The Project

Medical Lab is an application that can provide a status report on the level of progress of people (or supposed people) affected by diabetes. This is done by taking into account the information of the patients but also the notes collected by the doctor on these patients during the consultations.

Project goals:

    Use Agile methodology
    Create a front microservice for the application (module front).
    Create a microservice for SQL data access (module patient using MySQL).
    Create a microservice for NoSQL data access (module note using MongoDB).
    Create a microservice api gateway for communicated with differents microservice (module gateway).
    Create a microservice for diabetes assessment (module diagnostic).
    Deploy the app in docker containers.



### Technologies used
.Spring-boot 4.0.0

.Bootstrap 4

.java 17

.HTML 5

.css 3

.MySql 8

.workbench 8(my sql)

.MongodbCompass.lnk

.maven 3.9.x

.Docker 

## Getting Started

This is how to set up the project locally. To get a local copy up and running follow these simple example steps:

### Prerequisites

Check that you have:
.Java 17 installed

.For Windows Home Edition, use WSL2(Windows subsystem Linux)

.Docker Desktop


### Installation

1.Choose a directory

cd /path/to/directory/project

2.Clone the repo

git clone https://github.com/bpbanga/projet9Java

3.Select the project9 directory

cd project9

4.Assemble executable jar archives using maven wrapper provided in the folder, it downloads automatically the correct Maven version if necessary.

mvnw clean install

5.Launch the docker-compose to launch the 5 components:

docker-compose up

    To access the application endpoints, open your browser, go to :
    Front microservice REST API
    PATIENT Microservice REST API 
    NOTE Microservice REST API 
    GATEWAY microservice REST API 
    DIAGNOSTIC ASSESSMENT Microservice REST API

6. for run the application command:
   go to the racine: cd /medicallab
   run application: docker-compose up
   if yours images is not build: docker-compose up --build





 
