FROM openjdk:11
ADD target/docker-spring-department.jar docker-spring-department.jar
EXPOSE 8002
ENTRYPOINT ["java","-jar","docker-spring-department.jar"]