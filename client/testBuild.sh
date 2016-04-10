#!/bin/sh

rm -r ../docker/nginx/explodedWar/*

gradle clean 

gradle -Penv=test.properties docker
