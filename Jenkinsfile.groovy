pipeline {
    agent any
    stages {        
        stage('Packer - Build init') {
            steps{
                sh 'cd ./packer/'
                sh 'packer init -machine-readable -parallel-builds=1 -timestamp-ui .'
            }
        }
        stage('Packer - Build') {
            steps{
                sh 'cd ./packer/'
                sh 'pwd && ls -lr'
                sh 'packer build -machine-readable -parallel-builds=1 -timestamp-ui -force .'
                sh '$?'
                sh 'for i in $(seq 100); do echo "fuck_"$i; done'
            }
        }
    }
    environment {
            PACKER_LOG="1"
    }
}