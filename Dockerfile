FROM openjdk:21
VOLUME /tmp
ADD build/libs/app-springboot-3.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
