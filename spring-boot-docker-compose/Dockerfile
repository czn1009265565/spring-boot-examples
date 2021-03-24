FROM openjdk:8-jdk-alpine

RUN mkdir /code
WORKDIR /code
COPY ./target/*.jar /code/app.jar

CMD java -jar -Xms256m -Xmx256m app.jar --spring.profiles.active=prod