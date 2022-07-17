pipeline {
    agent any
    stages {        
        stage('Packer - Build init') {
            steps{
                sh 'cd ./packer/'
                sh 'pwd && ls -lr'
                sh 'rm -frv build.*'
                sh 'rm -frv init.*'
                sh label: '', script: 'packer init -machine-readable -parallel-builds=1 -timestamp-ui .'
            }
        }
        stage('Packer - Build') {
            steps{
                sh 'cd ./packer/'
                sh 'pwd && ls -lr'
                sh 'rm -frv build.*'
                sh 'rm -frv init.*'
                sh label: '', script: "${env.PACKER_SH} ."
                // sh 'chmod +x buildPacker.sh'
                // sh 'bash -x ./buildPacker.sh'
                // sh 'packer build -machine-readable -parallel-builds=1 -timestamp-ui -force .'
            }
        }
    }
    environment {
            PACKER_LOG="1"
            PACKER_SH = '/usr/bin/packer build -machine-readable -parallel-builds=1 -timestamp-ui -force -color=false '
    }
}