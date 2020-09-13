#/bin/sh
docker ps -a | grep Exited | awk '{print $1}' | xargs docker rm
docker images | grep springboot-jwt-starter_auth-svr | awk '{print $3}' | xargs docker rmi
docker images | grep none | awk '{print $3}' | xargs docker rmi
