
Kubernetes Cluster - A cluster consists of a master API server and a set of worker VMs called nodes.

Pod - A kubernetes pod is a group of containers, tied together for the purposes of administration and networking. It can contain a single container or multiple.

setup/ - This directory contains scripts to create & delete the cluster and remove storage.

. setenv.sh - Export variables to parent shell

. clientEnv.sh - Export variables to work with chatappp pod to parent shell

. serverEnv.sh - Export variables to work with chatserver pod to parent shell

pushService.sh - Push the docker image to Container Registry

runService.sh - Create the pod and run it using the docker image pushed to Container Registry

exposeServcie.sh - Allow external traffic

createIngress.sh - Create Ingress / HTTP load balancer

cleanup.sh - delete the pod and replication containers

