#!/bin/sh

basedir=`pwd`

cd ${basedir}/nginx

./start.sh

cd ${basedir}/tomcat

./build.sh
./start.sh
