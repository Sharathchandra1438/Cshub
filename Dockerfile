FROM eclipse-temurin:21-jdk-alpine

WORKDIR /app

COPY . .

# Give execution permission to mvnw
RUN chmod +x mvnw

# Build the app
RUN ./mvnw clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/cshub-0.0.1-SNAPSHOT.jar"]

