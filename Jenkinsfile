def gv

pipeline {
    agent any
    tools {
        maven "maven-3.9"
    }

    stages {
        stage('Load Script') {
            steps {
                script {
                    gv = load('script.groovy')
                }
            }
        }
        stage('Build jar') {
            steps {
                script{
                   gv.buildJar()
                }

            }
        }
        stage('Build image') {
            steps {
                script {
                    gv.buildAndPushImage()
                }
            }
        }
        stage('Deploy') {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}