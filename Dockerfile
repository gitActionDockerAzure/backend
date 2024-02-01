FROM openjdk:17
WORKDIR /app
COPY dockertest-0.0.1-SNAPSHOT.jar dockertest-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "dockertest-0.0.1-SNAPSHOT.jar"]
EXPOSE 7777
