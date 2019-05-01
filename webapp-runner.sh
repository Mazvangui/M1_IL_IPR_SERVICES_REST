#!/bin/bash

# Téléchargement du runner jetty (https://www.eclipse.org/jetty/documentation/9.4.x/runner.html)
wget -O webapp-runner.jar -c http://central.maven.org/maven2/com/github/jsimone/webapp-runner/9.0.16.0/webapp-runner-9.0.16.0.jar

# Compilation du war dans target
mvn package

# Lancement du projet (à adapter si le jar change)
java -jar webapp-runner.jar target/pr.tp.services-0.0.1-SNAPSHOT.war