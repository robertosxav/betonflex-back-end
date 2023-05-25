FROM eclipse-temurin:17-jdk-alpine
VOLUME ./Docker-Compose/
ARG JAR_FILE=./api-betonflex/target/*.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
EXPOSE 5432/tcp
