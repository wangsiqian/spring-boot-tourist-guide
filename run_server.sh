#!/bin/bash

mvn clean spring-boot:run -Dspring-boot.run.profiles=dev -Dpmd.skip=true -Dmaven.test.skip=true
