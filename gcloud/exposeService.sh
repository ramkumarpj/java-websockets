#!/bin/sh

if [ -z "${SERVICE}" ]; then
        echo "SERVICE is not set"
        error=1
fi

if [ -z "${SERVICE_TYPE}" ]; then
        echo "SERVICE_TYPE is not set"
        error=1
fi


if [ -n "${error}" ]; then
        echo "Error.."
        exit $error
fi

echo "Service set to ${SERVICE}"
echo "Service Type set to ${SERVICE_TYPE}"

kubectl expose rc ${SERVICE}  --type="${SERVICE_TYPE}"
