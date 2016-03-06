#!/bin/sh

host=`docker-machine ip default`

docker stop tomcat8

docker rm tomcat8

docker run -it --rm --name tomcat8 -p 8080:8080 tomcat8

echo "TOMCAT running at - http://${host}:8080/"

docker ps 
