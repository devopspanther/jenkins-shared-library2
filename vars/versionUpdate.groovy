def call() {
    withCredentials([usernamePassword(credentialsId: 'github-id', usernameVariable: 'USER', passwordVariable: 'PASS')]) {
        
        sh 'git config --global user.email "jenkins@example.com"'
        sh 'git config --global user.name "jenkins"'
        sh 'git remote set-url origin https://$USER:$PASS@github.com/devopspanther/jenkins-exercises-nana.git'
        sh 'git add .'
        sh 'git commit -m "ci: version bump"'
        sh 'git push origin HEAD:master'
    }
            
}