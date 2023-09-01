def call() {
    echo "Building docker image"           
    withCredentials([usernamePassword(credentialsId: 'dockerhub-id', usernameVariable: 'USER', passwordVariable: 'PASS')]){
        sh "docker build -t akodevops/myapp:${IMAGE_NAME} ."
        sh 'echo $PASS | docker login -u $USER --password-stdin'
        sh "docker push akodevops/myapp:${IMAGE_NAME}"
               
    }

}
            
