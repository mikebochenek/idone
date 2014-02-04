JBoss & Angular JS
----------------------

	cd ~/Dev/workspace/idone
	mvn clean package jboss-as:deploy
	mvn clean package jboss-as:redeploy
	http://localhost:8080/idone

	mvn clean package jboss-as:deploy
	mvn jboss-as:undeploy
	mvn clean test -Parq-jbossas-remote 
    mvn dependency:sources
    mvn dependency:resolve -Dclassifier=javadoc
