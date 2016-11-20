#!/bin/sh

#. clientEnv.sh

if [ -z "${INGRESS_YAML}" ]; then
	echo "YAML file not provided"
	error=1
fi

if [ -z "${PROJECT_ID}" ]; then
	echo "project id is not set"
        error=1
fi

if [ -z "${VERSION}" ]; then
	echo "version number is not set"
        error=1
fi

if [ -z "${SERVICE}" ]; then
	echo "Service is not set"
        error=1
fi

if [ -z "${PORT}" ]; then
	echo "Port is not set"
        error=1
fi

if [ ! -f "./${INGRESS_YAML}" ]; then
	echo "${YAML_FILE} does not exist"
	error=1
fi

echo "Project Id set to ${PROJECT_ID}"

echo "Version Number set to ${VERSION}"

echo "Service set to ${SERVICE}"

echo "Port number set to ${PORT}"

echo "YAML file set to ${INGRESS_YAML}"

if [ -n "${error}" ]; then
	echo "Error.."
   	exit $error
fi

gcloud config set project $PROJECT_ID

gcloud config set compute/zone us-central1-b


kubectl create -f $INGRESS_YAML

