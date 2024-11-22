FROM eclipse-temurin:17 AS build
WORKDIR /app
COPY . .
RUN ./gradlew clean bootJar --stacktrace --no-daemon

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]
