FROM alpine/java:20-jre

COPY application/build/libs/application-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-Dspring.profiles.active=prod", "-jar", "/app.jar"]
EXPOSE 8080