# Stage 1 : Build the artifact
FROM gradle:latest as BUILD_JAR
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME
COPY . .
RUN gradle clean build

# Stage 2 : Build the wanted image
FROM eclipse-temurin:17-jdk as CREATE_WEBAPP
ENV APP_HOME=/usr/app
ENV APP_NAME=loot-table-3.0.0.jar
WORKDIR $APP_HOME/
COPY --from=BUILD_JAR $APP_HOME/build/libs/$APP_NAME .
ENTRYPOINT exec java -jar $APP_NAME
