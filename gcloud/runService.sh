#!/bin/sh

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

echo "Project Id set to ${PROJECT_ID}"

echo "Version Number set to ${VERSION}"

echo "Service set to ${SERVICE}"

echo "Port number set to ${PORT}"

if [ -n "${error}" ]; then
	echo "Error.."
   	exit $error
fi

gcloud config set project $PROJECT_ID

gcloud config set compute/zone us-central1-b


kubectl run ${SERVICE} --image=gcr.io/${PROJECT_ID}/${SERVICE}:${VERSION} --port=${PORT}

