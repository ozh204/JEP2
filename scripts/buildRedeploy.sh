#!/bin/sh

echo "************ UNDEPLOYING *******************"
~/glassfish4/glassfish/bin/asadmin undeploy TJE2
echo "************ BUILDING **********************"
mvn clean package -Dmaven.test.skip=true
echo "************ DEPLOYING *********************"
~/glassfish4/glassfish/bin/asadmin deploy target/TJE2.war
