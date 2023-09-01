def call() {
    ech0 "Building docker image"           
    withCredentials([usernamePassword(credentialsId: 'docker-credentials', usernameVariable: 'USER', passwordVariable: 'PASS')]){
        sh "docker build -t docker-hub-id/myapp:${IMAGE_NAME} ."
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push docker-hub-id/myapp:${IMAGE_NAME}"
    }
            
}