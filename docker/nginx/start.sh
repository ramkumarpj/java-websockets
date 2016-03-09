#!/bin/sh

basedir=`pwd`

host=`docker-machine ip default`

webapp_dir=${basedir}/explodedWar

echo "Web App direcory --> ${webapp_dir}"

docker stop nginx

docker rm nginx

docker run --name nginx -p 80:80 -d nginx

echo "NGINX running at - http://${host}:80/"

docker ps 
