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

if [ ! -z "${INGRESS_YAML}" ]; then
	kubectl delete -f ${INGRESS_YAML}
fi

kubectl delete services ${SERVICE} 

kubectl delete rc ${SERVICE}


