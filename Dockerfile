FROM gradle:7.6.0-jdk17 AS build
WORKDIR /app
COPY --chown=gradle:gradle build.gradle .
COPY --chown=gradle:gradle settings.gradle .
COPY --chown=gradle:gradle src ./src
RUN gradle clean bootJar --no-daemon

FROM eclipse-temurin:17-jre
WORKDIR /app
COPY --from=build /app/build/libs/*.jar app.jar
EXPOSE 9090
ENTRYPOINT ["java", "-jar", "app.jar"]
