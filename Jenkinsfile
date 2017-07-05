pipeline {
	agent any

	tools {
		maven 'Maven 3.2.1'
	}

	options {
		buildDiscarder (
			logRotator (numToKeepStr: '2')
		)
	}

	stages {
		stage ('Test') {
		 agent { label 'node_slave' }
			steps {
			  sh 'mvn clean test'
			}

			post {
				success {
					step([$class: 'CoberturaPublisher', autoUpdateHealth: false, autoUpdateStability: false, coberturaReportFile: '**/target/site/cobertura/coverage.xml', failUnhealthy: false, failUnstable: false, maxNumberOfBuilds: 0, onlyStable: false, sourceEncoding: 'ASCII', zoomCoverageChart: false])
				}
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

	/*post {

		failure {
		  sh 'git tag -a "unstable.$BRANCH_NAME.$BUILD_ID" -m "failed build" '
		  sh 'git push origin --tags'
		}

		success {
			sh 'git tag -a "stable.$BRANCH_NAME.$BUILD_ID" -m "stable build"'
			sh 'git push origin --tags'
		}
	}*/

	post {
	  failure {
		  echo "Updating Github commit with fail status"
			updateGitlabCommitStatus( name: 'jenkins-build', state: 'failed' )
		}

		success {
			echo "Updating Github commit with success status"
			updateGitlabCommitStatus( name: 'jenkins-build', state: 'success' )
		}
	}

}
