FROM openjdk:8
MAINTAINER matigou <admin@matigou.com>
VOLUME /tmp
ADD matigou-cloud-gateway.jar matigou-cloud-gateway.jar
RUN bash -c 'touch /matigou-cloud-gateway.jar'
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/matigou-cloud-gateway.jar"]