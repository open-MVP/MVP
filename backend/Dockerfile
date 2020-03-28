FROM openjdk:14-jdk-alpine
ARG JAR_FILE=target/backend.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]