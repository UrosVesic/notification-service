# Stage 1: Build the application
FROM maven:3.6.3-openjdk-17 as build
COPY src /usr/home/notification-service/src
COPY ./pom.xml /usr/home/notification-service
RUN mvn -f /usr/home/notification-service/pom.xml clean package -DskipTests

# Stage 2: Package the application
FROM openjdk:17-jdk
COPY --from=build /usr/home/notification-service/target/*.jar /notification-service.jar
EXPOSE 8082
ENTRYPOINT ["java","-jar","/notification-service.jar"]