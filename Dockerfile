FROM openjdk:8-jdk-alpine

WORKDIR /backend/neo4j
EXPOSE 8080

ARG JAR_FILE=target/backend-2.0.0.RELEASE.jar
COPY ${JAR_FILE} app.jar
#COPY target/dependency/* dependency
ENTRYPOINT ["java","-jar","app.jar"]