FROM openjdk:17-jdk-alpine
# The application's jar file
ADD target/csms-transaction-service-0.0.1-SNAPSHOT.jar csms-transaction-service-0.0.1-SNAPSHOT.jar
# Make port 8080 available to the world outside this container
EXPOSE 8080

ENTRYPOINT ["java","-jar","csms-transaction-service-0.0.1-SNAPSHOT.jar"]