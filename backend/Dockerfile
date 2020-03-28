FROM openjdk:14-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT [
"java",
"-Dspring.data.mongodb.uri=mongodb://mongo:27017/open-mvp",
"-Djava.security.egd=file:/dev/./urandom",
"-jar",
"/app.jar"
]