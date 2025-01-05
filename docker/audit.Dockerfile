FROM openjdk:22
ARG TARGET_PATH=./source/audit-app/target
ARG JAR_FILE=${TARGET_PATH}/audit-app-0.0.1.jar
COPY ${JAR_FILE} /app.jar
USER root
RUN chmod +x ./app.jar
EXPOSE 8080
WORKDIR /
ENTRYPOINT ["java", "-jar", "app.jar"]