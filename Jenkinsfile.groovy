pipeline {
    agent any
    stages {
        stage('Packer - Build init') {
            steps{
                sh """
                #!/bin/bash
                export PACKER_LOG=1
                cd ./packer/
                packer init .
                packer build -force .
                """
            }
        }
        stage('Packer - Build') {
            steps{
                sh """
                #!/bin/bash
                export PACKER_LOG=1
                cd ./packer/
                packer build -force .
                """
            }
        }
    }
}