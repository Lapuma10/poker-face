FROM amazoncorretto:11-alpine-jdk
ENV APP_HOME=/usr/app/
WORKDIR $APP_HOME

COPY target/poker-face-0.0.1-SNAPSHOT.jar poker-face-0.0.1-SNAPSHOT.jar
#COPY build/libs/*.jar app.jar
EXPOSE 8080
#CMD ["java", "-jar", "app.jar"]
ENTRYPOINT ["java","-jar","poker-face-0.0.1-SNAPSHOT.jar"]