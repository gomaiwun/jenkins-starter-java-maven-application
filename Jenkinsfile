pipeline {
    agent any
    tools {
        maven "maven-3.9"
    }

    stages {
        stage('Build jar') {
            steps {
                echo 'Building the application ...'
                sh 'mvn package'
            }
        }
        stage('Build image') {
            steps {
                echo 'Building the docker image ...'
                withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                    sh 'docker build -t gomaiwun/demo-app:jma-2.0 .'
                    sh 'echo $PASS | docker login -u $USER --password-stdin'
                    sh 'docker push gomaiwun/demo-app:jma-2.0'
                }
            }
        }
        stage('Deploy') {
            steps {
                echo 'Deploying....'
            }
        }
    }

    post {
        always {
            echo "The job is done ..."
        }

        success {

        }

        failure {

        }
    }
}