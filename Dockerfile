# image for petClinic spring boot application
# jar file present in target folder
# base image as openjdk jre with version 17 
# copy jar file from target folder to docker image
# expose port 9966
# run jar file

FROM openjdk:17-jdk-alpine
COPY target/*.jar petclinic.jar
EXPOSE 9966
CMD ["java","-jar","/petclinic.jar"]

#  build docker image
#  docker build -t petclinic:1.0 .

