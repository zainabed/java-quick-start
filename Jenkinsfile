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
				sh 'mvn clean verify'
			}
		}
		
		stage ('Build') {
			when {
				branch 'develop'
			}
			steps {
				sh 'mvn clean install'
			}
			
			post {
				success {
					archiveArtifacts artifacts: 'target/*.jar',  fingerprint: true
				}
			}
		}
	}
	
	
	
	
}