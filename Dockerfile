FROM openjdk:17
WORKDIR /app
COPY ./build/libs/dockertest-0.0.1-SNAPSHOT.jar CardVisorBE.jar
ENTRYPOINT ["java", "-jar", "CardVisorBE.jar"]
