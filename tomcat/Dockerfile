FROM centos:7.8.2003
MAINTAINER xylon
ADD jdk-8u251-linux-x64.tar.gz  /usr/local/
ADD apache-tomcat-8.5.55.tar.gz /usr/local/

ENV JAVA_HOME /usr/local/jdk1.8.0_251/
ENV CLASSPATH $JAVA_HOME/jre/lib/rt.jar:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar
ENV CATALINA_HOME /usr/local/apache-tomcat-8.5.55
ENV PATH $PATH:$JAVA_HOME/bin:$CATALINA_HOME/lib:$CATALINA_HOME/bin

ADD tomcat /etc/init.d/tomcat
RUN chmod 755 /etc/init.d/tomcat

EXPOSE 8080
ENTRYPOINT /etc/init.d/tomcat start && tail -f /usr/local/apache-tomcat-8.5.55/logs/catalina.out