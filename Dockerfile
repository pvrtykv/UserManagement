FROM openjdk:17-jdk-slim-buster

COPY ./ /app

WORKDIR /app
RUN ./gradlew bootJar
RUN cp build/libs/usermanagement.jar /entrypoint.jar

WORKDIR /
RUN rm -rf /app /root/.gradle

CMD ["java", "-jar", "entrypoint.jar"]