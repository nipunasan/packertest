pipeline {
    agent any
    stages {        
        stage('Packer - Build init') {
            steps{
                sh 'cd /var/lib/jenkins/workspace/packer-build/packer'
                sh 'packer init .'
            }
        }
        stage('Packer - Build') {
            steps{
                sh 'cd /var/lib/jenkins/workspace/packer-build/packer && packer build -force .'
            }
        }
    }
    environment {
            PACKER_LOG="1"
    }
}