FROM openjdk:8-jre-alpine
EXPOSE 8084
WORKDIR /app
COPY target/insurance-0.0.1-SNAPSHOT.jar .
ENTRYPOINT [ "java", "-jar", "insurance-0.0.1-SNAPSHOT.jar" ]