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

if [ -z "${DOCKER_BASE}" ]; then
	echo "DOCKER BASE is not set"
	error=1
fi


if [ -n "${error}" ]; then
	echo "Error.."
   	exit $error
fi

echo "Project Id set to ${PROJECT_ID}"

echo "Version Number set to ${VERSION}"

echo "Service set to ${SERVICE}"

echo "Port number set to ${PORT}"

echo "Docker Base set to ${DOCKER_BASE}"

basedir=`pwd`

dockerdir="${basedir}/../docker"

gcloud config set project $PROJECT_ID

gcloud config set compute/zone us-central1-b

cd $dockerdir/${DOCKER_BASE}


docker build -t gcr.io/${PROJECT_ID}/${SERVICE}:${VERSION} .


gcloud docker push gcr.io/${PROJECT_ID}/${SERVICE}:${VERSION}

