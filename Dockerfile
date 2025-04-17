FROM openjdk:21-jdk
COPY target/Home-Schedules-*.jar /HomeSchedules.jar
CMD ["java", "-jar", "/HomeSchedules.jar"]