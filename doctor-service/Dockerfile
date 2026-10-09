FROM eclipse-temurin:25-jdk-alpine
ARG JAR_FILE=target/doctor-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
EXPOSE 8082
ENTRYPOINT ["java", "-jar","/app.jar"]