#!/bin/bash

mvn clean spring-boot:run -Dspring-boot.run.profiles=docker -Dpmd.skip=true -Dmaven.test.skip=true
