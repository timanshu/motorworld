FROM openjdk:12-jdk-alpine
ARG JAR_FILE
RUN mkdir /code
COPY target/motorworld-0.0.1-SNAPSHOT.jar /code
ENTRYPOINT ["java","-jar","/code/motorworld-0.0.1-SNAPSHOT.jar"]