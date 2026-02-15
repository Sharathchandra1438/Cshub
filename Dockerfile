FROM eclipse-temurin:17-jdk-alpine

WORKDIR /app

COPY . .

# Install Maven inside container
RUN apk add --no-cache maven

# Build app using Maven
RUN mvn clean package -DskipTests

EXPOSE 8080

CMD ["java", "-jar", "target/*.jar"]
