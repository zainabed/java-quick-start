pipeline {
	agent any
	
	options {
		buildDiscarder (
			logRotator (numToKeepStr: '2')
		) 
	}
	
	stages {
		stage ('Test') {
			steps {
			  sh 'mvn clean test'
			}
		}
		
		stage ('Integration') {
			when {
		   		branch 'develop'
		   	}
			
			steps {
				sh 'mvn clean verify -Dmaven.test.skip=true'
			}
		}
		
		stage ('Build') {
			when {
				branch 'develop'
			}
			steps {
				sh 'mvn clean install -Dmaven.test.skip=true -Dmaven.verify.skip=true'
			}
			
			post {
				success {
					archiveArtifacts artifacts: 'target/*.jar',  fingerprint: true
				}
				
			}
		}
		
		post {
			
			failure {
			  sh 'git tag -a "unstable" -m "failed build" ' 
			}
			
			success {
				sh 'git tag -a "stable" -m "stable build"'
			}
		}
	}
	
}