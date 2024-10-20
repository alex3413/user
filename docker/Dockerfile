FROM openjdk:22
ARG JAR_FILE=target/user-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} /app.jar
USER root
RUN chmod +x ./app.jar
EXPOSE 8080
WORKDIR /
ENTRYPOINT ["java", "-jar", "app.jar"]