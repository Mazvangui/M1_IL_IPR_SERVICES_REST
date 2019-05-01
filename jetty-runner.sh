#!/bin/bash

# Téléchargement du runner jetty (https://www.eclipse.org/jetty/documentation/9.4.x/runner.html)
wget -O jetty-runner.jar -c http://central.maven.org/maven2/org/eclipse/jetty/jetty-runner/9.4.15.v20190215/jetty-runner-9.4.15.v20190215.jar

# Compilation du war dans target
mvn package

# Lancement du projet (à adapter si le jar change)
java -jar jetty-runner.jar target/pr.tp.services-0.0.1-SNAPSHOT.war