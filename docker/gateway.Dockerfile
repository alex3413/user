FROM openjdk:22
ARG TARGET_PATH=./source/gateway/target
ARG JAR_FILE=${TARGET_PATH}/gateway-0.0.1.jar
COPY ${JAR_FILE} /app.jar
USER root
RUN chmod +x ./app.jar
EXPOSE 8090
WORKDIR /
ENTRYPOINT ["java", "-jar", "app.jar"]