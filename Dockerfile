FROM openjdk:17-jdk-alpine
COPY . /app
WORKDIR /app
RUN ./mvnw package

ENTRYPOINT ["java", "-jar", "/app/target/todo-0.0.1-SNAPSHOT.jar"]
