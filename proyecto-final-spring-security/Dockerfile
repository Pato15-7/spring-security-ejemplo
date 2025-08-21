FROM openjdk:17-jdk-slim
ARG JAR_FILE=target/proyecto-final-spring-security-0.0.1.jar
COPY ${JAR_FILE} app_security.jar
ENTRYPOINT ["java", "-jar", "app_security.jar"]