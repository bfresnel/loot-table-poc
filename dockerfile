FROM eclipse-temurin:16-jdk
COPY /build/libs/loot-table-2.0.0-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
