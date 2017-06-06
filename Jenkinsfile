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
		
	}
	
	post {
			
		failure {
		  sh 'git tag -a "unstable $GIT_BRANCH-$BUILD_ID" -m "failed build" ' 
		  sh 'git push origin --tags'
		}
		
		success {
			sh 'git tag -a "stable $GIT_BRANCH-$BUILD_ID" -m "stable build"'
			sh 'git pusho origin --tags'
		}
	}
	
}