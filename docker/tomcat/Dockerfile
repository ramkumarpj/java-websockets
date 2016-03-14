FROM tomcat:8.0.32-jre8

ENV CATALINA_HOME /usr/local/tomcat
ENV PATH $CATALINA_HOME/bin:$PATH
WORKDIR $CATALINA_HOME

ENV TOMCAT_MAJOR 8
ENV TOMCAT_VERSION 8.0.32
ENV TOMCAT_TGZ_URL https://www.apache.org/dist/tomcat/tomcat-$TOMCAT_MAJOR/v$TOMCAT_VERSION/bin/apache-tomcat-$TOMCAT_VERSION.tar.gz

COPY lib/*jar "$CATALINA_HOME"/lib/

ADD war/WebSocket.war "$CATALINA_HOME/webapps/

EXPOSE 8080
CMD ["catalina.sh", "run"]
