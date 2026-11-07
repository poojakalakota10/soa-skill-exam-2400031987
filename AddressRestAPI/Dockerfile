FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY target/AddressRestAPI-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 2007

ENTRYPOINT ["java", "-jar", "app.jar"]