#!/bin/sh

basedir=`pwd`

cd ${basedir}/nginx

./stop.sh

cd ${basedir}/tomcat

./stop.sh

