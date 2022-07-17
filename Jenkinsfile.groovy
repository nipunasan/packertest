pipeline {
    agent any
    stages {
        stage('Packer - Build') {
            steps{
                sh """
                #!/bin/bash
                cd ./packer/
                /sbin/packer init .
                /sbin/packer build -force .
                """
            }
        }
    }
}