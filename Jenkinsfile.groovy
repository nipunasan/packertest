pipeline {
    agent any
    stages {        
        stage('Packer - Build init') {
            steps{
                sh 'cd /var/lib/jenkins/workspace/packer-build/packer'
                sh 'packer init -machine-readable .'
            }
        }
        stage('Packer - Build') {
            steps{
                sh 'cd /var/lib/jenkins/workspace/packer-build/packer'
                sh 'packer build -machine-readable -force .'
            }
        }
    }
    environment {
            PACKER_LOG="1"
    }
}