#!/bin/sh

basedir=`pwd`

cd ${basedir}/nginx

./build.sh

cd ${basedir}/tomcat

./build.sh

