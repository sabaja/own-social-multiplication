pipeline {
    agent { docker { image 'maven:3.5.2' } }
    stages {
        stage('build') {
            steps {
                sh 'mvn --version'
            }
        }
	stage('end') {
            steps {
                echo 'End!'
            }
        }
    }
}
