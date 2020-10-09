pipeline {
    agent any
    }
    stages {

        stage('Git Checkout') {
                    steps {
                       git credentialsId: 'GIT_CREDENTIALS', url: 'https://github.com/vasante/googleSearchTest.git'
                    }
                }
        stage('Build') {
            steps {
                sh 'mvn -B -DskipTests clean package'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test '
            }
            post {
                always {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }
}
