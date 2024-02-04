# Stage 1: Build the React application
FROM node as frontend
WORKDIR /app
COPY frontend/package*.json ./
RUN npm install
COPY frontend/ ./
RUN npm run build

# Stage 2: Build the Spring Boot application
FROM openjdk as backend
WORKDIR /app
COPY backend/ ./
RUN chmod +x ./gradlew
RUN ./gradlew build

# Stage 3: Set up the Apache server
FROM ubuntu:20.04
RUN apt-get update && \
    apt-get install -y apache2 && \
    apt-get install -y openjdk-17-jdk && \
    rm -rf /var/lib/apt/lists/*

COPY --from=frontend /app/build /var/www/html
COPY --from=backend /app/build/libs/*.jar /app/
COPY backend/.github/workflows/000-default.conf /etc/apache2/sites-available/
CMD service apache2 start && java -jar /app/*.jar

EXPOSE 80
