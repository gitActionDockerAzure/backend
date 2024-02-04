# Stage 1: Copy the React application
FROM node as frontend-build
WORKDIR /app
COPY ../../frontend/build/ ./

# Stage 2: Copy the Spring Boot application
FROM openjdk as backend-build
WORKDIR /app
COPY ../../backend/build/libs/ ./

# Stage 3: Set up the Apache server
FROM ubuntu:20.04 as server-setup
ARG DEBIAN_FRONTEND=noninteractive
RUN apt-get update && \
    apt-get install -y apache2 && \
    apt-get install -y openjdk-17-jdk && \
    apt-get install -y tzdata && \
    apt-get install -y locales && \
    locale-gen ko_KR.UTF-8 && \
    rm -rf /var/lib/apt/lists/*

ENV LANG ko_KR.UTF-8  
ENV LANGUAGE ko_KR:ko  
ENV LC_ALL ko_KR.UTF-8
    
COPY --from=frontend-build /app /var/www/html
COPY --from=backend-build /app/*.jar /app/
COPY ../../backend/.github/workflows/000-default.conf /etc/apache2/sites-available/
CMD service apache2 start && while true; do sleep 1000; done & java -jar /app/*.jar
EXPOSE 80
