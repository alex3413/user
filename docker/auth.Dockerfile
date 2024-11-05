FROM openjdk:22
ARG TARGET_PATH=./source/user-auth/target
ARG JAR_FILE=${TARGET_PATH}/user-auth-0.0.1.jar
COPY ${JAR_FILE} /app.jar
USER root
RUN chmod +x ./app.jar
EXPOSE 9000
WORKDIR /
ENTRYPOINT ["java", "-jar", "app.jar"]