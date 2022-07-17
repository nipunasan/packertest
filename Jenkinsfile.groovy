pipeline {
    agent any
    stages {        
        stage('Packer - Build init') {
            steps{
                sh 'cd ./packer/'
                sh 'packer init .'
            }
        }
        stage('Packer - Build') {
            steps{
                sh 'cd ./packer/'
                sh 'packer build -force .'
            }
        }
    }
    environment {
            PACKER_LOG="1"
    }
}