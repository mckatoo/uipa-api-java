#!/bin/bash

docker run -d --name uipa-mysql -p3306:3306 -e MYSQL_DATABASE=testedb -e MYSQL_ROOT_PASSWORD=123456 mysql
