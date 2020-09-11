FROM gradle

RUN mkdir /usr/local/work/app
WORKDIR /usr/local/work/app

COPY . .
RUN gradle build

FROM adoptopenjdk/openjdk11
RUN adduser -Dh /home/rocksea rocksea
WORKDIR /app
COPY /usr/src/app/target/auth-0.1.0-SNAPSHOT.jar .
ENTRYPOINT ["java", "-jar", "/app/auth-0.1.0-SNAPSHOT.jar"]
