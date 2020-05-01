FROM wangsiqian/java-driver:1.0.1

COPY src/ /opt/app/src
COPY pom.xml /opt/app/pom.xml

WORKDIR /opt/app
