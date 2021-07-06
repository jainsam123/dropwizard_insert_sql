FROM openjdk:8-jre-alpine3.9
EXPOSE 3306
COPY target/HelloWorld-1.0-SNAPSHOT.jar /demo.jar
COPY config.yml .
CMD java -jar /demo.jar server config.yml