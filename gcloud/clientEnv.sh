#!/bin/sh

export SERVICE=chatapp

export SERVICE_TYPE=NodePort

export PORT=80

export DOCKER_BASE=nginx

export INGRESS_YAML=chatAppIngress.yaml

export INGRESS_SERVICE_NAME=chatapp-ingress
