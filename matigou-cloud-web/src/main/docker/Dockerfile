FROM openjdk:8
MAINTAINER matigou <admin@matigou.com>
VOLUME /tmp
ADD matigou-cloud-web.jar app.jar
RUN bash -c 'touch /app.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/app.jar"]