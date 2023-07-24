# image for petClinic spring boot application
# base image should be maven with jdk version 17
# copy pom.xml file to /tmp directory
# copy src directory to /tmp directory
# run mvn package command
# base image should be openjdk with jdk version 17
# copy jar file from /tmp/target directory to /opt directory
# set working directory to /opt directory
# expose port 9966
# run jar file

FROM maven:3.8.3-openjdk-17 AS build
COPY pom.xml /tmp/
COPY src /tmp/src/
RUN mvn -f /tmp/pom.xml clean package

FROM openjdk:17-jdk-alpine
COPY --from=build /tmp/target/*.jar /opt/app.jar
WORKDIR /opt
EXPOSE 9966
ENTRYPOINT ["java", "-jar", "app.jar"]


