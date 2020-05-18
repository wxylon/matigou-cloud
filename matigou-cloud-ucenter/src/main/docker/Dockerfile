FROM tomcat8:latest
MAINTAINER matigou <admin@matigou.com>
ADD matigou-cloud-ucenter.war /usr/local/apache-tomcat-8.5.55/webapps/ROOT.war
ENTRYPOINT /etc/init.d/tomcat start && tail -f /usr/local/apache-tomcat-8.5.55/logs/catalina.out