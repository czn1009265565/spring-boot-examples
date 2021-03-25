FROM openjdk:8-jdk-alpine

RUN mkdir /code
WORKDIR /code
COPY ./target/*.jar /code/app.jar

CMD java -jar app.jar