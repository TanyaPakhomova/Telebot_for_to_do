FROM openjdk:11
VOLUME /tmp
ARG JAR_FILE
COPY target/TelegramNotifierBot-spring-boot.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]