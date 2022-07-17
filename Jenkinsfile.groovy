pipeline {
    agent any
    stages {
        environment {
            PACKER_LOG=1
        }
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
}