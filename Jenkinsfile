def gv

pipeline {
    agent any
    tools {
        maven "maven-3.9"
    }

    stages {
        stage('init'){
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }
        stage('Build jar') {
            steps {
                gv.buildJar()
            }
        }
        stage('Build image') {
            steps {
                gv.buildImage()
            }
        }
        stage('Deploy') {
            steps {
                egv.deployApp
            }
        }
    }
}