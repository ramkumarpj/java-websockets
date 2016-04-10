#!/bin/sh


if [ -z "${PROJECT_ID}" ]; then
	echo "Error..PROJECT_ID not set."
   	exit 1
fi


echo "PROJECT_ID=${PROJECT_ID}"

gcloud config set project $PROJECT_ID

gcloud config set compute/zone us-central1-b

gcloud container clusters create chatapp-cluster --num-nodes 1 --machine-type g1-small


