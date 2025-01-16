def buildJar() {
    echo "Building JAR..."
    sh "mvn package"
    echo "JAR build complete"
}

def buildAndPushImage() {
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        echo "Building and pushing Docker image..."
        sh "docker build -t gomaiwun/demo-app:jma-2.0 ."
        sh "docker push gomaiwun/demo-app:jma-2.0"
        echo  "Image build and push complete"
    }
}

def deployApp() {
    echo "Deploying application..."
    // Actual deployment command
    // sh "your_deployment_command"
    echo "Deployment complete"
}

return this