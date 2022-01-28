#!/usr/bin/env bash

mvn -DskipTests=true spring-boot:build-image
docker run -p8080:8080 docker.io/library/mauritian-adventure:0.0.1-SNAPSHOT
