FROM adoptopenjdk:11-jre-hotspot
RUN mkdir /app
COPY ./target/*.jar /app/application.jar
CMD java -jar /app/application.jar