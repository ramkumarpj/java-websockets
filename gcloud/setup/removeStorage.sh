#!/bin/sh

storage=`gsutil ls`
gsutil rm -r $storage

