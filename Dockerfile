FROM openjdk:8
ADD target/java-spring-boot-mongodb-starter-1.0.0.jar java-spring-boot-mongodb-starter-1.0.0.jar
EXPOSE 8080
#Prodcution AppD Agent details
ENTRYPOINT ["java","-jar","java-spring-boot-mongodb-starter-1.0.0.jar"]
