FROM openjdk:11
ADD build/libs/app.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]