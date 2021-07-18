FROM adoptopenjdk/openjdk11:latest
EXPOSE 8084
WORKDIR /app
COPY target/insurance-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "insurance-0.0.1-SNAPSHOT.jar" ]