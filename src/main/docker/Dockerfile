FROM openjdk:17
ADD target/FileManager-0.0.1-SNAPSHOT.jar FileManager-0.0.1-SNAPSHOT.jar
ARG JAR_FILE=*.jar
COPY ${JAR_FILE} application.jar
ENTRYPOINT ["java", "-jar", "FileManager-0.0.1-SNAPSHOT.jar"]