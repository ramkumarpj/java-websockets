#!/bin/sh

if [ -z "${SERVICE}" ]; then
        echo "SERVICE is not set"
        error=1
fi


if [ -n "${error}" ]; then
        echo "Error.."
        exit $error
fi

echo "Service set to ${SERVICE}"

kubectl get services ${SERVICE}

if [ ! -z "${INGRESS_SERVICE_NAME}" ]; then
	kubectl get ingress ${INGRESS_SERVICE_NAME} --watch
fi 
