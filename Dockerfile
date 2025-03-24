FROM openjdk:17-jdk-slim

WORKDIR /app

COPY pom.xml .

COPY src ./src

RUN ./mvnw package -DskipTests

COPY target/blog-backend.jar blog-backend.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "blog-backend.jar"]
