FROM openjdk
WORKDIR usr/lib
ADD ./target/demoJWTApplication-0.0.1-SNAPSHOT.jar /usr/lib/demoJWTApplication-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","demoJWTApplication-0.0.1-SNAPSHOT.jar"]