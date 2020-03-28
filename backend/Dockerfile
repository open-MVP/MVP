#
# Build stage
#
FROM maven:3.6.3-jdk-14 AS build
COPY src /home/app/src
COPY pom.xml /home/app
RUN mvn -f /home/app/pom.xml clean package

#
# Package stage
#
FROM openjdk:14-jdk-alpine
COPY --from=build /home/app/target/backend.jar /usr/local/lib/app.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-Dserver.port=$PORT $JAVA_OPTS","-jar","/usr/local/lib/app.jar", "$PORT"]

EXPOSE $PORT