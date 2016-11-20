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

kubectl expose rc ${SERVICE}  --type="NodePort"
