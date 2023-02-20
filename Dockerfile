FROM openjdk:17
EXPOSE 8080
ADD /target/dockersprint dockersprint.jar
ENTRYPOINT ["java","-jar","dockersprint.jar"]