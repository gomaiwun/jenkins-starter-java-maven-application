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
        stage('test') {
            script {
                gv.test()
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
            when {
                expression {
                    BRANCH_NAME == "main"
                }
            }
            steps {
                script {
                    gv.buildAndPushImage()
                }
            }
        }
        stage('Deploy') {
            when {
                expression {
                    BRANCH_NAME == "main"
                }
            }
            steps {
                script {
                    gv.deployApp()
                }
            }
        }
    }
}
