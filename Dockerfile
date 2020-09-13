FROM adoptopenjdk:8-jdk-hotspot AS builder
RUN mkdir /app
WORKDIR /app
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle . 
COPY src src
RUN chmod +x ./gradlew
RUN SPRING_PROFILES_ACTIVE=docker ./gradlew bootjar

FROM adoptopenjdk/openjdk11:ubi
#FROM adoptopenjdk:8-jdk-hotspot
WORKDIR /app
COPY --from=builder /app/build/libs/*.jar auth.jar
EXPOSE 8080
ENTRYPOINT ["java", "-Dspring.profiles.active=docker", "-jar", "auth.jar"]
