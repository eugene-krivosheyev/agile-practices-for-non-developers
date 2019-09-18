FROM fabric8/java-alpine-openjdk8-jre:1.6.3
EXPOSE 8080
COPY target/dbo-1.0-SNAPSHOT.jar /usr/lib/ 
ENTRYPOINT java -jar /usr/lib/dbo-1.0-SNAPSHOT.jar --spring.profiles.active=it
